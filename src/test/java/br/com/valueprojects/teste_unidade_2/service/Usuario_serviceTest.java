package br.com.valueprojects.teste_unidade_2.service;

import br.com.valueprojects.teste_unidade_2.dto.Usuario_dto;
import br.com.valueprojects.teste_unidade_2.entity.Usuario;
import br.com.valueprojects.teste_unidade_2.repository.Usuario_Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class Usuario_serviceTest {

    @Mock
    private Usuario_Repository usuario_repository;

    @InjectMocks
    private Usuario_service usuario_service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void queryAllUsuarios() {
        List<Usuario> list = new ArrayList<Usuario>();
        Usuario usuario = new Usuario();
        usuario.setNome("Joao");
        usuario.setEmail("joao@gmail.com");
        usuario.setPapel("basico");
        list.add(usuario);

        Mockito.when(usuario_repository.findAll()).thenReturn(list);

        List<Usuario_dto> listDTO = usuario_service.queryAllUsuarios();

        assertNotNull(listDTO);
        assertTrue(listDTO.size() > 0);

    }

    @Test
    void save() {
        Usuario usuario = new Usuario();
        usuario.setNome("Joao");
        usuario.setEmail("joao@gmail.com");
        usuario.setPapel("basico");

        Mockito.when(usuario_repository.save(Mockito.any())).thenReturn(usuario);

        Usuario_dto dto = usuario_service.save(Usuario_dto.fromEntity(usuario));

        assertNotNull(dto);
        assertEquals(dto.getNome(), usuario.getNome());

    }

    @Test
    void upgrade() {
        Usuario usuario = new Usuario();
        usuario.setNome("Joao");
        usuario.setEmail("joao@gmail.com");
        usuario.setPapel("basico");
        usuario.setId(Long.valueOf(1));

        Mockito.when(usuario_repository.findById(usuario.getId())).thenReturn(Optional.of(usuario));
        Mockito.when(usuario_repository.save(Mockito.any())).thenReturn(usuario);

        Usuario_dto dto = usuario_service.upgrade(usuario.getId());

        assertNotNull(dto);
        assertEquals(dto.getNome(), usuario.getNome());

    }
}