package br.com.valueprojects.teste_unidade_2.service;

import br.com.valueprojects.teste_unidade_2.dto.Curso_dto;
import br.com.valueprojects.teste_unidade_2.entity.Curso;
import br.com.valueprojects.teste_unidade_2.repository.Curso_Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class Curso_serviceTest {

    @Mock
    private Curso_Repository repo;

    @InjectMocks
    private Curso_service service;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void queryAllCursos() {
        Curso curso = new Curso();
        curso.setNome("nome");
        curso.setId(Long.valueOf(1));

        List<Curso> list = List.of(curso);
        Mockito.when(repo.findAll()).thenReturn(list);

        List<Curso_dto> listDTO = service.queryAllCursos();

        assertNotNull(listDTO);
        assertEquals(list.size(), listDTO.size());
    }

    @Test
    void save() {

        Curso curso = new Curso();
        curso.setNome("nome");
        curso.setId(Long.valueOf(1));
        curso.setIdUsuario(Long.valueOf(2));
        curso.setCompleto(false);

        Curso_dto dto = Curso_dto.fromEntity(curso);

        Mockito.when(repo.save(Mockito.any())).thenReturn(curso);

        Curso_dto result = service.save(dto);

        assertNotNull(result);
        assertEquals(dto.getNome(), result.getNome());

    }

    @Test
    void completar() {

        Curso curso = new Curso();
        curso.setNome("nome");
        curso.setId(Long.valueOf(1));
        curso.setIdUsuario(Long.valueOf(2));
        curso.setCompleto(false);

        Curso_dto dto = Curso_dto.fromEntity(curso);
        List<Curso> list = new ArrayList<Curso>();
        list.add(curso);

        Mockito.when(repo.findById(Mockito.any())).thenReturn(Optional.of(curso));
        Mockito.when(repo.save(Mockito.any())).thenReturn(curso);

        Curso_dto result = service.completar(curso.getId());

        assertNotNull(result);
        assertEquals(dto.getNome(), result.getNome());
    }

    @Test
    void validarNumeroDeCursosCompletos() {
        Curso curso = new Curso();
        curso.setNome("nome");
        curso.setId(Long.valueOf(1));
        curso.setIdUsuario(Long.valueOf(2));
        curso.setCompleto(true);

        Curso_dto dto = Curso_dto.fromEntity(curso);
        List<Curso> list = new ArrayList<Curso>();
        list.add(curso);

        Mockito.when(repo.findByIdUsuario(curso.getIdUsuario())).thenReturn(list);

        Integer completos = service.validarNumeroDeCursosCompletos(curso.getIdUsuario());

        assertNotNull(completos);
        assertEquals(completos, 1);
    }
}