package com.santos.porto.teste.conteiner;

import com.santos.porto.teste.enuns.Categoria;
import com.santos.porto.teste.enuns.Status;
import com.santos.porto.teste.enuns.Tipo;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConteiner(
        @NotNull
        Long id,
        Tipo tipo,
        Status status,
        Categoria categoria
) {
}
