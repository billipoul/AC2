package br.com.valueprojects.teste_unidade_2.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JogoTest {
    @Test
    void testGettersAndSetters() {
        Jogo jogo = new Jogo();
        assertEquals("",jogo.getDescricao());
        assertEquals(0, jogo.getResultados().size());

        Resultados resultados = new Resultados();
        resultados.setPontuacao(1);
        resultados.setId_participante("participante");

        ArrayList<Resultados> resultadosArray = new ArrayList<Resultados>();
        resultadosArray.add(resultados);

        jogo.setDescricao("descricao");
        jogo.setResultados(resultadosArray);

        assertEquals(1, jogo.getResultados().size());
        assertEquals("descricao",jogo.getDescricao());
    }
}