package com.santos.porto.domain.movimentacao;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santos.porto.controller.DTO.DadosAtualizacaoMovimentacao;
import com.santos.porto.controller.DTO.DadosCadastroMovimentacao;
import com.santos.porto.domain.conteiner.Conteiner;
import com.santos.porto.domain.conteiner.enuns.TipoMovimentacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// anotações do JPA
@Table(name = "movimentacoes")
@Entity(name = "Movimentacao")

//Anotações do LOMBOK para gerar getter setter constructor etc
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_movimentacao")
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "data_hora_inicio")
    private @NotNull LocalDateTime dataHoraInicio;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "data_hora_fim")
    private LocalDateTime dataHoraFim;

    @ManyToOne
    @JoinColumn(name = "conteiner_id")
    private Conteiner conteiner;

    public Movimentacao(DadosCadastroMovimentacao dados) {
        this.tipoMovimentacao = dados.tipoMovimentacao();
        this.dataHoraInicio = dados.dataHoraInicio();
        this.dataHoraFim = dados.dataHoraFim();
        this.conteiner = dados.toConteiner();
    }

    public void atualizarInformacoes(DadosAtualizacaoMovimentacao dados) {

        if (dados.tipoMovimentacao() != null) {
            this.tipoMovimentacao = dados.tipoMovimentacao();
        }
        if (dados.dataHoraInicio() != null) {
            this.dataHoraInicio = dados.dataHoraInicio();
        }
        if (dados.dataHoraFim() != null) {
            this.dataHoraFim = dados.dataHoraFim();
        }
    }
}
