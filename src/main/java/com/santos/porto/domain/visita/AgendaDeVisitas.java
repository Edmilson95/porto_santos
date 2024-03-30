package com.santos.porto.domain.visita;

import com.santos.porto.controller.DTO.DadosAgendamentoVisita;
import com.santos.porto.controller.DTO.DadosCancelamentoVisita;
import com.santos.porto.controller.DTO.DadosDetalhamentoVisita;
import com.santos.porto.controller.VisitaController;
import com.santos.porto.domain.ValidacaoException;
import com.santos.porto.domain.conteiner.Conteiner;
import com.santos.porto.domain.movimentacao.Movimentacao;
import com.santos.porto.domain.repository.ConteinerRepository;
import com.santos.porto.domain.repository.MovimentacaoRepository;
import com.santos.porto.domain.repository.VisitaRepository;
import com.santos.porto.domain.visita.validacoes.agendamento.ValidadorAgendamentoDeVisita;
import com.santos.porto.domain.visita.validacoes.cancelamento.ValidadorCancelamentoDeVisita;
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

    @Autowired
    private List<ValidadorCancelamentoDeVisita> validadoresCancelamento;

    public DadosDetalhamentoVisita agendar(DadosAgendamentoVisita dados){
        if (dados.idConteiner() != null && !conteinerRepository.existsById(dados.idConteiner())){
            throw new ValidacaoException("ID do Conteiner não existe.");
        }
        if (dados.idMovimentacao() != null && !movimentacaoRepository.existsById(dados.idMovimentacao())){
            throw  new ValidacaoException("ID da Movimentacao não existe.");
        }
        if (dados.data() == null){
            throw new ValidacaoException("Necessário data para agendamento de visita.");
        }
        var data = dados.data();

        var conteiner = escolherConteiner(dados);
        var movimentacao = escolherMovimentacao(dados);
        var visita = new Visita(null, null, conteiner, movimentacao, data);
        visitaRepository.save(visita);

        return new DadosDetalhamentoVisita(visita);
    }

    private Movimentacao escolherMovimentacao(DadosAgendamentoVisita dados){
        if (dados.idMovimentacao() == null){
            throw new ValidacaoException("Dados não podem ser nulos!");
        }

        return movimentacaoRepository.getReferenceById(dados.idMovimentacao());
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

        validadoresCancelamento.forEach(v -> {
            v.validar(dados);
        });

        var visita = visitaRepository.getReferenceById(dados.idVisita());
        visita.cancelar(dados.motivo());
    }
}
