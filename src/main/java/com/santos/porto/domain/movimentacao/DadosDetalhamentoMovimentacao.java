package com.santos.porto.domain.movimentacao;

import com.santos.porto.domain.enuns.TipoMovimentacao;

import java.time.LocalDateTime;

public record DadosDetalhamentoMovimentacao(Long id, TipoMovimentacao tipoMovimentacao, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {

    public DadosDetalhamentoMovimentacao(Movimentacao movimentacao){
        this(movimentacao.getId(), movimentacao.getTipoMovimentacao(), movimentacao.getDataHoraInicio(), movimentacao.getDataHoraFim());
    }
}
