package com.santos.porto.teste.conteiner;

import com.santos.porto.teste.conteiner.repository.ConteinerRepository;
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
        Conteiner conteiner = new Conteiner(dados);
        repository.save(conteiner);
        return conteiner;
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
