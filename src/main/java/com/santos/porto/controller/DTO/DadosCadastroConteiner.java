package com.santos.porto.controller.DTO;

import com.santos.porto.domain.enuns.Categoria;
import com.santos.porto.domain.enuns.Status;
import com.santos.porto.domain.enuns.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record DadosCadastroConteiner(

        @NotBlank
        String cliente,

        @Pattern(regexp = "[A-Za-z]{4}[0-9]{7}$")
        String numero,

        @NotNull
        Tipo tipo,

        @NotNull
        Status status,

        @NotNull
        Categoria categoria) {

}
