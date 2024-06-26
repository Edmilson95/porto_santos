package com.santos.porto.controller;

import com.santos.porto.controller.DTO.DadosAgendamentoVisita;
import com.santos.porto.controller.DTO.DadosCancelamentoVisita;
import com.santos.porto.controller.DTO.DadosDetalhamentoVisita;
import com.santos.porto.domain.visita.AgendaDeVisitas;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/visitas")
@SecurityRequirement(name = "bearer-key")
public class VisitaController {

    @Autowired
    private AgendaDeVisitas agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody(required = false) @Valid DadosAgendamentoVisita dados){
        if (dados == null){
            return ResponseEntity.badRequest().body("Informações inválidas");
        }
        var dto = agenda.agendar(dados);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoVisita dados){
        agenda.cancelar(dados);
        return ResponseEntity.noContent().build();
    }
}
