package br.com.valueprojects.teste_unidade_2.repository;

import br.com.valueprojects.teste_unidade_2.entity.Curso;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CursoRepositoryTest {

    @Autowired
    private Curso_Repository repo;

    @Test
    public void testCreateAndQueryCurso(){
        Curso curso = new Curso();

        curso.setNome("nome");
        curso.setCompleto(true);
        curso.setIdUsuario(Long.valueOf(1));

        Curso databaseCurso = repo.save(curso);
        assertNotNull(databaseCurso);

        Optional<Curso> databaseQueryCurso = repo.findById(databaseCurso.getId());
        assertNotNull(databaseQueryCurso);
        assertTrue(databaseQueryCurso.isPresent());
        assertEquals(databaseCurso.getNome(), curso.getNome());
        assertEquals(databaseCurso.getCompleto(), curso.getCompleto());
        assertEquals(databaseCurso.getIdUsuario(), curso.getIdUsuario());

    }

}