package com.santos.porto.controller.DTO;

import com.santos.porto.domain.conteiner.Conteiner;
import com.santos.porto.domain.enuns.Categoria;
import com.santos.porto.domain.enuns.Status;
import com.santos.porto.domain.enuns.Tipo;

public record DadosDetalhamentoConteiner(Long id, String cliente, String numero, Tipo tipo, Status status, Categoria categoria) {

    public DadosDetalhamentoConteiner(Conteiner conteiner){
        this(conteiner.getId(), conteiner.getCliente(), conteiner.getNumero(), conteiner.getTipo(), conteiner.getStatus(), conteiner.getCategoria());
    }
}
