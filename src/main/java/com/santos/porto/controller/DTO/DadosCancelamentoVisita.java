package com.santos.porto.controller.DTO;

import com.santos.porto.domain.conteiner.enuns.MotivoCancelamento;
import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoVisita (

        Long idVisita,

        @NotNull
        MotivoCancelamento motivo)
{
}
