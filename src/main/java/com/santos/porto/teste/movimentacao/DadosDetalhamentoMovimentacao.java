package com.santos.porto.teste.movimentacao;

import com.santos.porto.teste.enuns.TipoMovimentacao;

import java.time.LocalDateTime;

public record DadosDetalhamentoMovimentacao(Long id, TipoMovimentacao tipoMovimentacao, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {

    public DadosDetalhamentoMovimentacao(Movimentacao movimentacao){
        this(movimentacao.getId(), movimentacao.getTipoMovimentacao(), movimentacao.getDataHoraInicio(), movimentacao.getDataHoraFim());
    }
}
