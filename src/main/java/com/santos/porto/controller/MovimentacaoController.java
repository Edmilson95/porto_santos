package com.santos.porto.controller;

import com.santos.porto.controller.DTO.DadosAtualizacaoMovimentacao;
import com.santos.porto.controller.DTO.DadosCadastroMovimentacao;
import com.santos.porto.controller.DTO.DadosDetalhamentoMovimentacao;
import com.santos.porto.controller.DTO.DadosListagemMovimentacao;
import com.santos.porto.domain.movimentacao.*;
import com.santos.porto.domain.conteiner.enuns.Categoria;
import com.santos.porto.domain.repository.MovimentacaoRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("movimentacao")
@SecurityRequirement(name = "bearer-key")
public class MovimentacaoController {
    @Autowired
    private MovimentacaoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMovimentacao dados, UriComponentsBuilder uriBuilder){
        var movimentacao = new Movimentacao(dados);

        repository.save(movimentacao);

        var uri = uriBuilder.path("movimentacao/{id}").buildAndExpand(movimentacao.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMovimentacao(movimentacao));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMovimentacao>> listar(@PageableDefault(size = 10, sort = { "dataHoraInicio" }) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemMovimentacao::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMovimentacao dados){
        var movimentacao = repository.getReferenceById(dados.id());
        movimentacao.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMovimentacao(movimentacao));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){ //a anotação pathVariable é para dizer que o parametro esta indo pela URL
        repository.deleteById(id);
//        desta forma eu excluo o dado pela URL
        return ResponseEntity.noContent().build();
    }

    //    relatório do tipo de movimentações por cliente
    @GetMapping("/relatorio")
    public ResponseEntity<List<String>> relatorio(){

        List<Movimentacao> listaMovimentacoes = repository.findAllByOrderByConteiner();
        List<String> relatorio = new ArrayList<>();

        int contadorExportacao = 0;
        int contadorImportacao = 0;

        relatorio.add("*-*-*-*-*- RELATÓRIO DE MOVIMENTAÇÕES *-*-*-*-*-*-*");

        for(int i = 0; i < listaMovimentacoes.size(); i++) {

            Movimentacao movimentacaoConteiner = listaMovimentacoes.get(i);
            relatorio.add("Cliente: " + movimentacaoConteiner.getConteiner().getCliente() + " | Tipo de movimentação: " +
                    movimentacaoConteiner.getTipoMovimentacao());

            if(movimentacaoConteiner.getConteiner().getCategoria().equals(Categoria.EXPORTACAO)){
                contadorExportacao++;
            } else if (movimentacaoConteiner.getConteiner().getCategoria().equals(Categoria.IMPORTACAO)){
                contadorImportacao++;
            }
        }

        relatorio.add("                                      ");
        relatorio.add("*-*-*-**---*-* SUMÁRIO -*-*-**--**-*-*");
        relatorio.add("TOTAL DE IMPORTAÇÕES: " + contadorImportacao + " | TOTAL DE EXPORTAÇÕES: "+ contadorExportacao);


        return ResponseEntity.ok().body(relatorio);
    }
}
