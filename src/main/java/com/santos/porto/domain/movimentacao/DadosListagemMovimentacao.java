package com.santos.porto.domain.movimentacao;

import com.santos.porto.domain.enuns.TipoMovimentacao;

import java.time.LocalDateTime;

public record DadosListagemMovimentacao(Long id, TipoMovimentacao tipoMovimentacao, LocalDateTime inicio, LocalDateTime fim) {
    public DadosListagemMovimentacao(Movimentacao movimentacao){
        this(movimentacao.getId(), movimentacao.getTipoMovimentacao(), movimentacao.getDataHoraInicio(), movimentacao.getDataHoraFim());
    }
}
