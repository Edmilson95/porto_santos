package com.santos.porto.domain.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class VisitaRepositoryTest {

    @Autowired
    private ConteinerRepository conteinerRepository;

    @Test
    @DisplayName("Quando o conteiner possui outra visita no mesmo horario retorna uma exception")
    void existsByConteinerIdAndDataAndMotivoCancelamentoIsNullCenario1() {

    }

    @Test
    void existsByConteinerIdAndDataBetween() {
    }
}