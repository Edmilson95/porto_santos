package com.santos.porto.teste.controller;


import com.santos.porto.teste.conteiner.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/conteiner")
public class ConteinerController {

    @Autowired
    ConteinerRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroConteiner dados, UriComponentsBuilder uriBuilder){
        var conteiner = new Conteiner(dados);

        repository.save(conteiner);

        var uri = uriBuilder.path("/conteiner/{id}").buildAndExpand(conteiner.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoConteiner(conteiner));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemConteiner>> listar(@PageableDefault(size = 10, sort = { "cliente" }) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemConteiner::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoConteiner dados){
        var conteiner = repository.getReferenceById(dados.id());
        conteiner.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoConteiner(conteiner));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){ //a anotação pathVariable é para dizer que o parametro esta indo pela URL
        repository.deleteById(id);
//        desta forma eu excluo o dado pela URL
        return ResponseEntity.noContent().build();
    }
}
