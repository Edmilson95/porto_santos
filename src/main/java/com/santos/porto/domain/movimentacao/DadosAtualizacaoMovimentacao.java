package com.santos.porto.domain.movimentacao;

import com.santos.porto.domain.enuns.TipoMovimentacao;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAtualizacaoMovimentacao(
        @NotNull Long id,


        TipoMovimentacao tipoMovimentacao,

        LocalDateTime dataHoraInicio,

        LocalDateTime dataHoraFim
) {
}
