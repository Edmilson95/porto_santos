package com.santos.porto.domain.visita.validacoes;

import com.santos.porto.controller.DTO.DadosAgendamentoVisita;
import com.santos.porto.domain.ValidacaoException;
import com.santos.porto.domain.visita.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorConteinerSemOutraVisitaNoDia implements ValidadorAgendamentoDeVisita{
    @Autowired
    private VisitaRepository repository;

    public void validar(DadosAgendamentoVisita dados){
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var conteinerPossuiOutraVisitaNoDia = repository.existsByConteinerAndDataBetween(dados.idConteiner(), primeiroHorario, ultimoHorario);
        if (conteinerPossuiOutraVisitaNoDia){
            throw new ValidacaoException("Conteiner já possui uma visita agendada nesse dia.");
        }
    }
}
