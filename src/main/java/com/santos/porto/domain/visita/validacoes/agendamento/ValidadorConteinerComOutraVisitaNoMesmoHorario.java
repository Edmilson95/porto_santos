package com.santos.porto.domain.visita.validacoes.agendamento;

import com.santos.porto.controller.DTO.DadosAgendamentoVisita;
import com.santos.porto.domain.ValidacaoException;
import com.santos.porto.domain.visita.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorConteinerComOutraVisitaNoMesmoHorario implements ValidadorAgendamentoDeVisita {

    @Autowired
    private VisitaRepository repository;

    public void validar(DadosAgendamentoVisita dados){
        var conteinerPossuiOutraVisitaNoMesmoHorario = repository.existsByConteinerIdAndDataAndMotivoCancelamentoIsNull(dados.idConteiner(), dados.data());
        if (conteinerPossuiOutraVisitaNoMesmoHorario){
            throw new ValidacaoException("Conteiner já possui outra visita agendada nesse mesmo horário.");
        }

    }

}
