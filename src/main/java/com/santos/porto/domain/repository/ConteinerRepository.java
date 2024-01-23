package com.santos.porto.domain.repository;

import com.santos.porto.domain.conteiner.Conteiner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ConteinerRepository extends JpaRepository<Conteiner, Long> {
}
