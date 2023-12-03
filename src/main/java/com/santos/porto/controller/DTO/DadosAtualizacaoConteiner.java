package com.santos.porto.controller.DTO;

import com.santos.porto.domain.enuns.Categoria;
import com.santos.porto.domain.enuns.Status;
import com.santos.porto.domain.enuns.Tipo;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConteiner(
        @NotNull
        Long id,
        Tipo tipo,
        Status status,
        Categoria categoria
) {
}
