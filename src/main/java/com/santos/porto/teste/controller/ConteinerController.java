package com.santos.porto.teste.controller;


import com.santos.porto.teste.conteiner.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conteiner")
public class ConteinerController {

    @Autowired
    ConteinerRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroConteiner dados){
        repository.save(new Conteiner(dados));
    }

    @GetMapping
    public Page<DadosListagemConteiner> listar(@PageableDefault(size = 10, sort = { "cliente" }) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemConteiner::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoConteiner dados){
        var conteiner = repository.getReferenceById(dados.id());
        conteiner.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){ //a anotação pathVariable é para dizer que o parametro esta indo pela URL
        repository.deleteById(id);
//        desta forma eu excluo o dado pela URL
    }
}
