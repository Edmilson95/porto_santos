package com.santos.porto.teste.conteiner;

import com.santos.porto.teste.conteiner.repository.ConteinerRepository;
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
}
