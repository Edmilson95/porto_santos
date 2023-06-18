package com.santos.porto.teste.movimentacao;

import com.santos.porto.teste.conteiner.Conteiner;
import com.santos.porto.teste.enuns.TipoMovimentacao;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroMovimentacao(
        @NotNull
        TipoMovimentacao tipoMovimentacao,
        @NotNull
        LocalDateTime dataHoraInicio,
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

