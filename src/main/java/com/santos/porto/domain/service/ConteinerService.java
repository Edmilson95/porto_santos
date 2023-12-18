package com.santos.porto.domain.service;

import com.santos.porto.controller.DTO.DadosAtualizacaoConteiner;
import com.santos.porto.controller.DTO.DadosCadastroConteiner;
import com.santos.porto.domain.repository.ConteinerRepository;
import com.santos.porto.domain.conteiner.Conteiner;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConteinerService {
    private ConteinerRepository repository;

    public ConteinerService(ConteinerRepository repository){
        this.repository = repository;
    }

    public List<Conteiner> listarConteiners(){
        List<Conteiner> lista = repository.findAll();
        return lista;
    }

    public Conteiner cadastrarConteiner(DadosCadastroConteiner dados){
        Conteiner conteinerNovo = new Conteiner(dados);
        repository.save(conteinerNovo);
        return conteinerNovo;
    }

    @Transactional
    public ResponseEntity<Object> atualizarConteiner(DadosAtualizacaoConteiner dados){
       var conteiner = repository.getReferenceById(dados.id());
       conteiner.atualizarInformacoes(dados);
       repository.save(conteiner);
       return ResponseEntity.ok("Conteiner atualizado com sucesso: \n" + conteiner);
    }

    @Transactional
    public void excluirConteiner(Long id){
        repository.deleteById(id);
    }

}
