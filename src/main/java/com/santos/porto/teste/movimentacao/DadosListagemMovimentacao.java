package com.santos.porto.teste.movimentacao;

import com.santos.porto.teste.enuns.TipoMovimentacao;

import java.time.LocalDateTime;

public record DadosListagemMovimentacao(Long id, TipoMovimentacao tipoMovimentacao, LocalDateTime inicio, LocalDateTime fim) {
    public DadosListagemMovimentacao(Movimentacao movimentacao){
        this(movimentacao.getId(), movimentacao.getTipoMovimentacao(), movimentacao.getDataHoraInicio(), movimentacao.getDataHoraFim());
    }
}
