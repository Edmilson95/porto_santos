package com.santos.porto.controller.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

public record DadosAgendamentoVisita(

        Long idConteiner,

        Long idMovimentacao,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        @Future
        LocalDateTime data

){

}
