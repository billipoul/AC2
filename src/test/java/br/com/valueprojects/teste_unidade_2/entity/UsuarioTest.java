package br.com.valueprojects.teste_unidade_2.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsuarioTest {
    @Test
    void testGettersAndSetters() {
        Usuario usuario = new Usuario();
        assertEquals(null,usuario.getNome());


        usuario.setNome("nome");
        usuario.setEmail("email@email.com");

        assertEquals("nome", usuario.getNome());
        assertEquals("email@email.com",usuario.getEmail());
    }
}