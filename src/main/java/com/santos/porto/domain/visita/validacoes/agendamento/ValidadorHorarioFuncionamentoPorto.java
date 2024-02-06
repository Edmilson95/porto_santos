package com.santos.porto.domain.visita.validacoes.agendamento;

import com.santos.porto.controller.DTO.DadosAgendamentoVisita;
import com.santos.porto.domain.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoPorto implements ValidadorAgendamentoDeVisita{

    public void validar(DadosAgendamentoVisita dados){
        var dataVisita = dados.data();

        var domingo = dataVisita.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaPorto = dataVisita.getHour() < 7;
        var depoisDoEncerramentoPorto =  dataVisita.getHour() > 18;
        if (domingo || antesDaAberturaPorto || depoisDoEncerramentoPorto){
            throw new ValidacaoException("Visita fora do horário de funcionamento do Porto");
        }

    }
}
