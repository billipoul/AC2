package br.com.valueprojects.teste_unidade_2.controller;

import br.com.valueprojects.teste_unidade_2.dto.Curso_dto;
import br.com.valueprojects.teste_unidade_2.service.Curso_service;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CursoController.class)
class CursoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Curso_service service;

    @Test
    void testListarCursos() throws Exception {
        Curso_dto dto = new Curso_dto();
        dto.setNome("nome");
        dto.setId(Long.valueOf(1));

        List<Curso_dto> listDTO = List.of(dto);
        Mockito.when(service.queryAllCursos()).thenReturn(listDTO);

        mockMvc.
                perform(
                        MockMvcRequestBuilders.get("/cursos").
                        accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(jsonPath("$[0].nome").value("nome"));
    }

    @Test
    void cadastrar() throws Exception {
        Curso_dto dto = new Curso_dto();
        dto.setNome("nome");
        dto.setId(Long.valueOf(1));

        Mockito.when(service.save(dto)).thenReturn(dto);
        Gson gson = new Gson();
        String json = gson.toJson(dto);


        mockMvc.
                perform(
                        MockMvcRequestBuilders.get("/cursos").
                                accept(MediaType.APPLICATION_JSON).content(json)).
                andExpect(status().isOk());
    }
}