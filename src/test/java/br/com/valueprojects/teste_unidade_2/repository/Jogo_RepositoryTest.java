package br.com.valueprojects.teste_unidade_2.repository;

import br.com.valueprojects.teste_unidade_2.entity.Jogo;
import br.com.valueprojects.teste_unidade_2.entity.Resultados;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class Jogo_RepositoryTest {

    @Autowired
    private Jogo_Repository repo;

    @Test
    public void testCreateAndQueryJogo(){
        Jogo jogo = new Jogo();

        Resultados resultados = new Resultados();
        resultados.setPontuacao(1);
        resultados.setId_participante("participante");

        ArrayList<Resultados> resultadosArray = new ArrayList<Resultados>();
        resultadosArray.add(resultados);

        jogo.setDescricao("descricao");
        jogo.setResultados(resultadosArray);

        Jogo databaseJogo = repo.save(jogo);
        assertNotNull(databaseJogo);

        Optional<Jogo> databaseQueryJogo = repo.findById(databaseJogo.getId());
        assertNotNull(databaseQueryJogo);
        assertTrue(databaseQueryJogo.isPresent());
        assertEquals(databaseJogo.getDescricao(), jogo.getDescricao());
        assertEquals(databaseJogo.getResultados(), jogo.getResultados());
    }

}