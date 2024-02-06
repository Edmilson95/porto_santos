package com.santos.porto.domain.visita.validacoes.agendamento;

import com.santos.porto.controller.DTO.DadosAgendamentoVisita;

public interface ValidadorAgendamentoDeVisita {

    void validar(DadosAgendamentoVisita dados);
}
