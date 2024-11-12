package br.com.valueprojects.teste_unidade_2.service;

import br.com.valueprojects.teste_unidade_2.dto.Jogo_dto;
import br.com.valueprojects.teste_unidade_2.entity.Jogo;
import br.com.valueprojects.teste_unidade_2.repository.Jogo_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Jogo_service {

    @Autowired
    private Jogo_Repository repo;

    public List<Jogo_dto> queryAllJogos() {
        List<Jogo> jogos = repo.findAll();
        return jogos.stream().map(Jogo_dto::fromEntity).collect(Collectors.toList());
    }

    public Jogo_dto save(Jogo_dto dto) {
        Jogo entity = repo.save(Jogo_dto.toEntity(dto));
        return Jogo_dto.fromEntity(entity);
    }
}
