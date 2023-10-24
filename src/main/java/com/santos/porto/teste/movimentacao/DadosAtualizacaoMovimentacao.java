package com.santos.porto.teste.movimentacao;

import com.santos.porto.teste.enuns.TipoMovimentacao;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAtualizacaoMovimentacao(
        @NotNull Long id,


        TipoMovimentacao tipoMovimentacao,

        LocalDateTime dataHoraInicio,

        LocalDateTime dataHoraFim
) {
}
