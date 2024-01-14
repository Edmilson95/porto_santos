package com.santos.porto.controller;

import com.santos.porto.controller.DTO.DadosAgendamenVisita;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visitas")
public class VisitaController {

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamenVisita dados){
        System.out.println(dados);
        return ResponseEntity.ok(new DadosDetalhamentoVisita(null, null, null, null))
    }

}
