package com.santos.porto.domain.visita;

import com.santos.porto.controller.DTO.DadosAgendamentoVisita;
import com.santos.porto.controller.VisitaController;
import com.santos.porto.domain.ValidacaoException;
import com.santos.porto.domain.conteiner.Conteiner;
import com.santos.porto.domain.repository.ConteinerRepository;
import com.santos.porto.domain.repository.MovimentacaoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeVisitas {

    @Autowired
    VisitaRepository visitaRepository;

    @Autowired
    ConteinerRepository conteinerRepository;

    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    public void agendar(DadosAgendamentoVisita dados){
        if (dados.idConteiner() != null && !conteinerRepository.existsById(dados.idConteiner())){
            throw new ValidacaoException("ID do Conteiner não existe.");
        }
        if (!movimentacaoRepository.existsById(dados.idMovimentacao())){
            throw  new ValidacaoException("ID da Movimentacao não existe.");
        }

        var conteiner = escolherConteiner(dados);
        var movimentacao = movimentacaoRepository.getReferenceById(dados.idMovimentacao());
        var visita = new Visita(null, conteiner, movimentacao, dados.data());
        visitaRepository.save(visita);
    }

    private Conteiner escolherConteiner(DadosAgendamentoVisita dados) {
        if (dados.idConteiner() != null){
            return conteinerRepository.getReferenceById(dados.idConteiner());
        }
    }
}
