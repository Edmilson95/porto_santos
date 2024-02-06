package com.santos.porto.controller.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santos.porto.domain.visita.Visita;

import java.time.LocalDateTime;

public record DadosDetalhamentoVisita (Long id,
                                       Long idConteiner,
                                       Long idMovimentacao,
                                       @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                       LocalDateTime data) {
    public DadosDetalhamentoVisita(Visita visita) {
        this(visita.getId(), visita.getConteiner().getId(), visita.getMovimentacao().getId(), visita.getData());
    }
}
