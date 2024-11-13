package br.com.valueprojects.teste_unidade_2.dto;


import br.com.valueprojects.teste_unidade_2.entity.Jogo;
import br.com.valueprojects.teste_unidade_2.entity.Resultados;
import br.com.valueprojects.teste_unidade_2.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Usuario_dto {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private String email;

    public Usuario_dto(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Usuario_dto() {}

    public static Usuario_dto fromEntity(Usuario usuario) {
        Usuario_dto usuario_dto = new Usuario_dto();
        usuario_dto.setId(usuario.getId());
        usuario_dto.setNome(usuario.getNome());
        usuario_dto.setEmail(usuario.getEmail());
        return usuario_dto;
    }

    public static Usuario toEntity(Usuario_dto dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        return usuario;
    }
}
