package com.santos.porto.controller.DTO;

import com.santos.porto.domain.enuns.TipoMovimentacao;
import com.santos.porto.domain.movimentacao.Movimentacao;

import java.time.LocalDateTime;

public record DadosListagemMovimentacao(Long id, TipoMovimentacao tipoMovimentacao, LocalDateTime inicio, LocalDateTime fim) {
    public DadosListagemMovimentacao(Movimentacao movimentacao){
        this(movimentacao.getId(), movimentacao.getTipoMovimentacao(), movimentacao.getDataHoraInicio(), movimentacao.getDataHoraFim());
    }
}
