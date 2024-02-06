package com.santos.porto.domain.visita.validacoes.agendamento;

import com.santos.porto.controller.DTO.DadosAgendamentoVisita;
import com.santos.porto.domain.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaVisita")
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeVisita{

    public void validar(DadosAgendamentoVisita dados){
        var dataVisita = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataVisita).toMinutes();
        if (diferencaEmMinutos < 30){
            throw new ValidacaoException("Visita deve ser agendada com antecedência miníma de 30 minutos.");
        }

    }

}
