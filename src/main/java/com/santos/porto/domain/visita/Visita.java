package com.santos.porto.domain.visita;

import com.santos.porto.controller.DTO.DadosAgendamentoVisita;
import com.santos.porto.domain.conteiner.Conteiner;
import com.santos.porto.domain.conteiner.enuns.MotivoCancelamento;
import com.santos.porto.domain.movimentacao.Movimentacao;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")

@Entity(name = "Visitas")
@Table(name = "visitas")
public class Visita {

    private MotivoCancelamento motivoCancelamento;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conteiner_id")
    private Conteiner conteiner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movimentacao_id")
    private Movimentacao movimentacao;

    private LocalDateTime data;

    public Visita(DadosAgendamentoVisita dadosAgendamentoVisita) {
    }


    public void cancelar(MotivoCancelamento motivo) {

        this.motivoCancelamento = motivo;
    }


}
