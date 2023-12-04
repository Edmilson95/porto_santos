package com.santos.porto.controller.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santos.porto.domain.conteiner.Conteiner;
import com.santos.porto.domain.conteiner.enuns.TipoMovimentacao;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroMovimentacao(
        @NotNull
        TipoMovimentacao tipoMovimentacao,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        @NotNull
        LocalDateTime dataHoraInicio,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        @NotNull
        LocalDateTime dataHoraFim,

        Long conteiner_id

) {
    public Conteiner toConteiner(){
        Conteiner conteiner = new Conteiner();
        conteiner.setId(conteiner_id);
        return conteiner;
    }
}

