package com.santos.porto.controller;
import com.santos.porto.controller.DTO.DadosAtualizacaoConteiner;
import com.santos.porto.domain.conteiner.Conteiner;
import com.santos.porto.controller.DTO.DadosCadastroConteiner;
import com.santos.porto.controller.DTO.DadosDetalhamentoConteiner;
import com.santos.porto.domain.service.ConteinerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/conteiner")
public class ConteinerController {

    @Autowired
    private ConteinerService conteinerService;

    public ConteinerController(ConteinerService conteinerService){
        this.conteinerService = conteinerService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroConteiner dados, UriComponentsBuilder uriBuilder){
        Conteiner conteiner = conteinerService.cadastrarConteiner(dados);

        var uri = uriBuilder.path("/conteiner/{id}").buildAndExpand(conteiner.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoConteiner(conteiner));
    }

    @GetMapping
    public ResponseEntity<List<Conteiner>> listar() {
        return ResponseEntity.ok(conteinerService.listarConteiners());
    }

    @PutMapping()
    public ResponseEntity<Object> atualizarConteiner(@RequestBody @Valid DadosAtualizacaoConteiner dados){
        if (dados.id() == null) {
            return ResponseEntity.badRequest().body("ID é obrigatório para atualização.");
        }

        return conteinerService.atualizarConteiner(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        conteinerService.excluirConteiner(id);
        return ResponseEntity.noContent().build();
    }

}
