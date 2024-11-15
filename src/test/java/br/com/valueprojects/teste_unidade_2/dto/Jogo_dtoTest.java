package br.com.valueprojects.teste_unidade_2.dto;

import br.com.valueprojects.teste_unidade_2.entity.Jogo;
import br.com.valueprojects.teste_unidade_2.entity.Resultados;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Jogo_dtoTest {

    @Test
    void fromEntity() {
        Jogo jogo = new Jogo();
        List<Resultados> resultados = new ArrayList<Resultados>();
        Resultados resultado = new Resultados();
        resultado.setId_participante("1");
        resultado.setPontuacao(1);
        resultados.add(resultado);
        jogo.setResultados(resultados);
        jogo.setDescricao("descricao");
        jogo.setId(Long.valueOf(1));

        Jogo_dto dto = Jogo_dto.fromEntity(jogo);

        assertEquals("descricao", dto.getDescricao());
        assertEquals(1, dto.getId());
        assertNotNull(dto.getResultados());
    }

    @Test
    void toEntity() {
        Jogo_dto dto = new Jogo_dto();
        dto.setDescricao("descricao");
        dto.setId(Long.valueOf(1));
        List<Jogo_dto.JogoResultados> resultados = new ArrayList<Jogo_dto.JogoResultados>();
        Jogo_dto.JogoResultados resultado = new Jogo_dto.JogoResultados();
        resultado.setId_participante("1");
        resultado.setPontuacao(1);
        resultados.add(resultado);
        dto.setResultados(resultados);

        Jogo jogo = Jogo_dto.toEntity(dto);
        assertEquals("descricao", jogo.getDescricao());
        assertEquals(1, jogo.getId());
        assertNotNull(jogo.getResultados());
    }
}