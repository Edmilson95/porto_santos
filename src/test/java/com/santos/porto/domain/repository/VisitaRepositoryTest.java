package com.santos.porto.domain.repository;

import com.santos.porto.controller.DTO.DadosAgendamentoVisita;
import com.santos.porto.controller.DTO.DadosCadastroConteiner;
import com.santos.porto.controller.DTO.DadosCadastroMovimentacao;
import com.santos.porto.domain.conteiner.Conteiner;
import com.santos.porto.domain.conteiner.enuns.*;
import com.santos.porto.domain.movimentacao.Movimentacao;
import com.santos.porto.domain.visita.Visita;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class VisitaRepositoryTest {

    @Autowired
    private VisitaRepository visitaRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    @DisplayName("Quando o conteiner possui outra visita no mesmo horario retorna uma exception")
    void existsByConteinerIdAndDataAndMotivoCancelamentoIsNullCenario1() {
        var proxSegundaAs10 = LocalDateTime.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .toLocalDate().atTime(10, 0);
        var proxSegundaAs10Mais30Min = proxSegundaAs10.plusMinutes(30);

        Long idConteiner = cadastrarConteiner("cliente", "1234ABCD", Tipo.PES_20, Status.CHEIO, Categoria.EXPORTACAO).getId();
        Long idMovimentacao = cadastrarMovimentacao(TipoMovimentacao.EMBARQUE, proxSegundaAs10, proxSegundaAs10Mais30Min,idConteiner).getId();
        cadastrarVisita(idConteiner, idMovimentacao, proxSegundaAs10Mais30Min);

       assertFalse(visitaRepository.existsByConteinerIdAndDataAndMotivoCancelamentoIsNull((long)1, proxSegundaAs10Mais30Min));
    }

    @Test
    void existsByConteinerIdAndDataBetween() {
    }

    private void cadastrarVisita(Long idConteiner, Long idMovimentacao, LocalDateTime data){
        Conteiner conteiner = em.find(Conteiner.class, idConteiner);
        Movimentacao movimentacao = em.find(Movimentacao.class, idMovimentacao);

        Visita visita = new Visita();
        visita.setConteiner(conteiner);
        visita.setMovimentacao(movimentacao);
        visita.setData(data);

        em.persist(visita);
    }

    private DadosAgendamentoVisita dadosVisita(Long idConteiner, Long idMovimentacao, LocalDateTime data){
        return new DadosAgendamentoVisita(
                idConteiner,
                idMovimentacao,
                data
        );
    }

    private Movimentacao cadastrarMovimentacao(TipoMovimentacao tipoMovimentacao, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, Long conteiner_id){
        var movimentacao = new Movimentacao(dadosMovimentacao(
                tipoMovimentacao,
                dataHoraInicio,
                dataHoraFim,
                conteiner_id
        ));
        em.persist(movimentacao);
        return movimentacao;
    }

    private DadosCadastroMovimentacao dadosMovimentacao(TipoMovimentacao tipoMovimentacao, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, Long conteiner_id){
        return new DadosCadastroMovimentacao(
                tipoMovimentacao,
                dataHoraInicio,
                dataHoraFim,
                conteiner_id
        );
    }

    private Conteiner cadastrarConteiner(String cliente, String numero, Tipo tipo, Status status, Categoria categoria){
        var conteiner = new Conteiner(dadosConteiner(
                cliente, numero, tipo, status, categoria));
        em.persist(conteiner);
        return conteiner;
    }

    private DadosCadastroConteiner dadosConteiner(String cliente, String numero, Tipo tipo, Status status, Categoria categoria){
        return new DadosCadastroConteiner(
                cliente,
                numero,
                tipo,
                status,
                categoria
        );
    }
}