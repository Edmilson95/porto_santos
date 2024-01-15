package com.santos.porto.controller.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DadosDetalhamentoVisita (Long id,
                                       Long idConteiner,
                                       Long idMovimentacao,
                                       @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                       LocalDateTime data) {
}
