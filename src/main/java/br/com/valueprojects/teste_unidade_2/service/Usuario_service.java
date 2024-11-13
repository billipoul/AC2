package br.com.valueprojects.teste_unidade_2.service;

import br.com.valueprojects.teste_unidade_2.dto.Usuario_dto;
import br.com.valueprojects.teste_unidade_2.entity.Jogo;
import br.com.valueprojects.teste_unidade_2.entity.Usuario;
import br.com.valueprojects.teste_unidade_2.repository.Jogo_Repository;
import br.com.valueprojects.teste_unidade_2.repository.Usuario_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Usuario_service {

    @Autowired
    private Usuario_Repository repo;

    public List<Usuario_dto> queryAllUsuarios() {
        List<Usuario> usuarios = repo.findAll();
        return usuarios.stream().map(Usuario_dto::fromEntity).collect(Collectors.toList());
    }

    public Usuario_dto save(Usuario_dto dto) {
        Usuario input = Usuario_dto.toEntity(dto);
        input.setPapel("Basico");
        Usuario entity = repo.save(input);
        return Usuario_dto.fromEntity(entity);
    }

    public Usuario_dto upgrade(long idUsuario) {
        Usuario input = repo.findById(idUsuario).get();
        input.setPapel("Total");
        Usuario entity = repo.save(input);
        return Usuario_dto.fromEntity(entity);
    }
}
