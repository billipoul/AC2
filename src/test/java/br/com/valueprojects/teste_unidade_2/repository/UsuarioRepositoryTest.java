package br.com.valueprojects.teste_unidade_2.repository;

import br.com.valueprojects.teste_unidade_2.entity.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UsuarioRepositoryTest {

    @Autowired
    private Usuario_Repository repo;

    @Test
    public void testCreateAndQueryUsuario(){
        Usuario usuario = new Usuario();

        usuario.setNome("nome");
        usuario.setEmail("email");
        usuario.setPapel("papel");

        Usuario databaseUsuario = repo.save(usuario);
        assertNotNull(databaseUsuario);

        Optional<Usuario> databaseQueryUsuario = repo.findById(databaseUsuario.getId());
        assertNotNull(databaseQueryUsuario);
        assertTrue(databaseQueryUsuario.isPresent());
        assertEquals(databaseUsuario.getNome(), usuario.getNome());
        assertEquals(databaseUsuario.getEmail(), usuario.getEmail());
        assertEquals(databaseUsuario.getPapel(), usuario.getPapel());

    }

}