package com.santos.porto.domain.visita;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface VisitaRepository extends JpaRepository<Visita, Long> {

    boolean existsByConteinerAndData(Long idConteiner, LocalDateTime data);

    boolean existsByConteinerAndDataBetween(Long idConteiner, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
}
