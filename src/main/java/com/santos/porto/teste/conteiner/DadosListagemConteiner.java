package com.santos.porto.teste.conteiner;

import com.santos.porto.teste.enuns.Categoria;
import com.santos.porto.teste.enuns.Status;
import com.santos.porto.teste.enuns.Tipo;

public record DadosListagemConteiner(Long id, String cliente, String numero, Tipo tipo, Status status, Categoria categoria) {

    public DadosListagemConteiner(Conteiner conteiner){
        this(conteiner.getId(), conteiner.getCliente(), conteiner.getNumero(), conteiner.getTipo(), conteiner.getStatus(),
                conteiner.getCategoria());
    }

}
