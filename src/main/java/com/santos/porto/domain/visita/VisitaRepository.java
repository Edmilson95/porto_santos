package com.santos.porto.domain.visita;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface VisitaRepository extends JpaRepository<Visita, Long> {

    boolean existsByConteinerIdAndDataAndMotivoCancelamentoIsNull(Long idConteiner, LocalDateTime data);

    boolean existsByConteinerIdAndDataBetween(Long idConteiner, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
}
