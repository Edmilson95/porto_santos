package com.santos.porto.domain.visita.validacoes.cancelamento;

import com.santos.porto.controller.DTO.DadosCancelamentoVisita;
import com.santos.porto.domain.ValidacaoException;
import com.santos.porto.domain.repository.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaCancelamento")
public class ValidadorHorarioAntecedencia implements ValidadorCancelamentoDeVisita {

    @Autowired
    private VisitaRepository repository;

    @Override
    public void validar(DadosCancelamentoVisita dados) {
        var visita = repository.getReferenceById(dados.idVisita());
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, visita.getData()).toHours();

        if (diferencaEmHoras < 24){
            throw new ValidacaoException("Visita somente pode ser cancelada com antecedência mínima de 24h!");
        }
    }
}
