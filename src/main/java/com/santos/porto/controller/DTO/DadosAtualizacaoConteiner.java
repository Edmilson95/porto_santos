package com.santos.porto.controller.DTO;

import com.santos.porto.domain.conteiner.enuns.Categoria;
import com.santos.porto.domain.conteiner.enuns.Status;
import com.santos.porto.domain.conteiner.enuns.Tipo;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConteiner(
        @NotNull
        Long id,
        Tipo tipo,
        Status status,
        Categoria categoria
) {
}
