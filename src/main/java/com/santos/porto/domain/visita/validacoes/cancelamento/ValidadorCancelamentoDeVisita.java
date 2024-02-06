package com.santos.porto.domain.visita.validacoes.cancelamento;

import com.santos.porto.controller.DTO.DadosAgendamentoVisita;
import com.santos.porto.controller.DTO.DadosCancelamentoVisita;


public interface ValidadorCancelamentoDeVisita {

    void validar(DadosCancelamentoVisita dados);
}
