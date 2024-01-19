package com.santos.porto.controller;

import com.santos.porto.controller.DTO.DadosAgendamentoVisita;
import com.santos.porto.controller.DTO.DadosDetalhamentoVisita;
import com.santos.porto.domain.visita.AgendaDeVisitas;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visitas")
public class VisitaController {

    @Autowired
    private AgendaDeVisitas agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoVisita dados){
        agenda.agendar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoVisita(null, null, null, null));
    }

}
