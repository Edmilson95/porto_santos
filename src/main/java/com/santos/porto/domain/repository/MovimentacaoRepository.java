package com.santos.porto.domain.repository;

import com.santos.porto.domain.movimentacao.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
    List<Movimentacao> findAllByOrderByConteiner();
}
