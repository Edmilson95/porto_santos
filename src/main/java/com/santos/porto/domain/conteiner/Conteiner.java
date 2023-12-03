package com.santos.porto.domain.conteiner;

import com.santos.porto.controller.DTO.DadosAtualizacaoConteiner;
import com.santos.porto.controller.DTO.DadosCadastroConteiner;
import com.santos.porto.domain.enuns.Categoria;
import com.santos.porto.domain.enuns.Status;
import com.santos.porto.domain.enuns.Tipo;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")

@Entity(name = "Conteiner")
@Table(name = "conteiner")
public class Conteiner {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;
    private String numero;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Conteiner(DadosCadastroConteiner dados) {
        this.cliente = dados.cliente();
        this.numero = dados.numero();
        this.tipo = dados.tipo();
        this.status = dados.status();
        this.categoria = dados.categoria();
    }

    public void atualizarInformacoes(DadosAtualizacaoConteiner dados) {
        if (dados.tipo() != null) {
            this.tipo = dados.tipo();
        }
        if (dados.status() != null) {
            this.status = dados.status();
        }
        if (dados.categoria() != null) {
            this.categoria = dados.categoria();

        }
    }

    @Override
    public String toString() {
        return
                "\n{" +
                "\n id = " + id +
                ",\n cliente = '" + cliente + '\'' +
                ",\n numero= '" + numero + '\'' +
                ",\n tipo = " + tipo +
                ",\n status = " + status +
                ",\n categoria = " + categoria +
                "\n}";
    }
}
