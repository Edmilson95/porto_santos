package com.santos.porto.domain.visita;

import com.santos.porto.controller.DTO.DadosAgendamentoVisita;
import com.santos.porto.controller.DTO.DadosCancelamentoVisita;
import com.santos.porto.controller.VisitaController;
import com.santos.porto.domain.ValidacaoException;
import com.santos.porto.domain.conteiner.Conteiner;
import com.santos.porto.domain.repository.ConteinerRepository;
import com.santos.porto.domain.repository.MovimentacaoRepository;
import com.santos.porto.domain.visita.validacoes.ValidadorAgendamentoDeVisita;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeVisitas {

    @Autowired
    VisitaRepository visitaRepository;

    @Autowired
    ConteinerRepository conteinerRepository;

    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private List<ValidadorAgendamentoDeVisita> validadores;

    public void agendar(DadosAgendamentoVisita dados){
        if (dados.idConteiner() != null && !conteinerRepository.existsById(dados.idConteiner())){
            throw new ValidacaoException("ID do Conteiner não existe.");
        }
        if (!movimentacaoRepository.existsById(dados.idMovimentacao())){
            throw  new ValidacaoException("ID da Movimentacao não existe.");
        }
        validadores.forEach(v -> v.validar(dados));


        var conteiner = escolherConteiner(dados);
        var movimentacao = movimentacaoRepository.getReferenceById(dados.idMovimentacao());
        var visita = new Visita(null, null, conteiner, movimentacao, dados.data());
        visitaRepository.save(visita);
    }

    private Conteiner escolherConteiner(DadosAgendamentoVisita dados) {
        if (dados.idConteiner() == null){
            throw new ValidacaoException("Dados não podem ser nulos!");
        }

        return conteinerRepository.getReferenceById(dados.idConteiner());
    }

    public void cancelar(DadosCancelamentoVisita dados) {
        if (!visitaRepository.existsById(dados.idVisita())){
            throw new ValidacaoException("ID da visita informada não existe.");
        }

        var visita = visitaRepository.getReferenceById(dados.idVisita());
        visita.cancelar(dados.motivo());
    }
}
