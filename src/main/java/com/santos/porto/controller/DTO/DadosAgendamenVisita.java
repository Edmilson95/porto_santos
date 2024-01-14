package com.santos.porto.controller.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DadosAgendamenVisita (

        @NotNull(message = "Campo obrigatório")
        Long id,
        @NotNull(message = "Campo obrigatório")
        Long idMedico,
        @NotNull(message = "Campo obrigatório")
        Long idPaciente,
        @NotNull(message = "Campo obrigatório")
        Date data


){

}
