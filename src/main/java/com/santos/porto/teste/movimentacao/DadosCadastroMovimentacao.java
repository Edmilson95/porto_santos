package com.santos.porto.teste.movimentacao;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santos.porto.teste.conteiner.Conteiner;
import com.santos.porto.teste.enuns.TipoMovimentacao;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroMovimentacao(
        @NotNull
        TipoMovimentacao tipoMovimentacao,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
        @NotNull
        LocalDateTime dataHoraInicio,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
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

