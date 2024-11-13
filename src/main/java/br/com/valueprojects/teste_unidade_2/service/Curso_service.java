package br.com.valueprojects.teste_unidade_2.service;

import br.com.valueprojects.teste_unidade_2.dto.Curso_dto;
import br.com.valueprojects.teste_unidade_2.entity.Curso;
import br.com.valueprojects.teste_unidade_2.repository.Curso_Repository;
import br.com.valueprojects.teste_unidade_2.repository.Curso_Repository;
import br.com.valueprojects.teste_unidade_2.repository.Usuario_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Curso_service {

    @Autowired
    private Curso_Repository repo;

    @Autowired
    private Usuario_service usuarioService;

    public List<Curso_dto> queryAllCursos() {
        List<Curso> usuarios = repo.findAll();
        return usuarios.stream().map(Curso_dto::fromEntity).collect(Collectors.toList());
    }

    public Curso_dto save(Curso_dto dto) {
        Curso input = Curso_dto.toEntity(dto);
        input.setCompleto(Boolean.FALSE);
        Curso entity = repo.save(input);
        return Curso_dto.fromEntity(entity);
    }

    public Curso_dto completar(long id) {
        Curso input = repo.findById(id).get();
        input.setCompleto(Boolean.TRUE);
        Curso entity = repo.save(input);

        if (validarNumeroDeCursosCompletos(input.getIdUsuario()) > 7) {
            usuarioService.upgrade(input.getIdUsuario());
        }

        return Curso_dto.fromEntity(entity);
    }

    public Integer validarNumeroDeCursosCompletos(long idUsuario) {
        List<Curso> cursos = repo.findByIdUsuario(idUsuario);

        int cursosCompletos = 0;
        for (Curso curso : cursos) {
            if (curso.getCompleto()) {
                cursosCompletos++;
            }
        }

        return cursosCompletos;
    }
}
