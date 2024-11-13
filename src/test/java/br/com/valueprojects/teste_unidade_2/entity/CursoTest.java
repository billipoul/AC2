package br.com.valueprojects.teste_unidade_2.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CursoTest {
    @Test
    void testGettersAndSetters() {
        Curso curso = new Curso();
        assertEquals(null,curso.getNome());


        curso.setNome("nome");
        curso.setCompleto(true);

        assertEquals("nome", curso.getNome());
        assertEquals(true,curso.getCompleto());
    }
}