package com.santos.porto.teste.conteiner;

import com.santos.porto.teste.enuns.Categoria;
import com.santos.porto.teste.enuns.Status;
import com.santos.porto.teste.enuns.Tipo;
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
