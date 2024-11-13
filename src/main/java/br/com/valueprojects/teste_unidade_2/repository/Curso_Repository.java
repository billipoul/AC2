package br.com.valueprojects.teste_unidade_2.repository;

import br.com.valueprojects.teste_unidade_2.entity.Curso;
import br.com.valueprojects.teste_unidade_2.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Curso_Repository extends JpaRepository<Curso, Long> {

    List<Curso> findByIdUsuario(long idUsuario);
}
