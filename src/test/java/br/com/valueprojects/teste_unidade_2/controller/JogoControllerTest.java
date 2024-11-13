package br.com.valueprojects.teste_unidade_2.controller;

import br.com.valueprojects.teste_unidade_2.dto.Jogo_dto;
import br.com.valueprojects.teste_unidade_2.service.Jogo_service;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(JogoController.class)
class JogoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Jogo_service service;

    @Test
    void testListarJogos() throws Exception {
        Jogo_dto dto = new Jogo_dto();
        dto.setDescricao("descricao");
        dto.setId(Long.valueOf(1));
        List<Jogo_dto.JogoResultados> jogoResultadosList = new ArrayList<Jogo_dto.JogoResultados>();
        dto.setResultados(jogoResultadosList);

        List<Jogo_dto> listDTO = List.of(dto);
        Mockito.when(service.queryAllJogos()).thenReturn(listDTO);

        mockMvc.
                perform(
                        MockMvcRequestBuilders.get("/jogos").
                        accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(jsonPath("$[0].descricao").value("descricao"));
    }

    @Test
    void cadastrar() throws Exception {
        Jogo_dto dto = new Jogo_dto();
        dto.setDescricao("descricao");
        dto.setId(Long.valueOf(1));
        List<Jogo_dto.JogoResultados> jogoResultadosList = new ArrayList<Jogo_dto.JogoResultados>();
        dto.setResultados(jogoResultadosList);

        List<Jogo_dto> listDTO = List.of(dto);
        Mockito.when(service.save(dto)).thenReturn(dto);
        Gson gson = new Gson();
        String json = gson.toJson(dto);


        mockMvc.
                perform(
                        MockMvcRequestBuilders.get("/jogos").
                                accept(MediaType.APPLICATION_JSON).content(json)).
                andExpect(status().isOk());
    }
}