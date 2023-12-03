package com.santos.porto.teste.controller;


import com.santos.porto.teste.conteiner.*;
import com.santos.porto.teste.conteiner.repository.ConteinerRepository;
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
    ConteinerRepository repository;

    ConteinerService conteinerService;

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

/*    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){ //a anotação pathVariable é para dizer que o parametro esta indo pela URL
        repository.deleteById(id);
//        desta forma eu excluo o dado pela URL
        return ResponseEntity.noContent().build();
    }
 */
}
