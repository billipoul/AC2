package br.com.valueprojects.teste_unidade_2.controller;

import br.com.valueprojects.teste_unidade_2.dto.Usuario_dto;
import br.com.valueprojects.teste_unidade_2.service.Usuario_service;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Usuario_service service;

    @Test
    void testListarUsuarios() throws Exception {
        Usuario_dto dto = new Usuario_dto();
        dto.setNome("nome");
        dto.setId(Long.valueOf(1));

        List<Usuario_dto> listDTO = List.of(dto);
        Mockito.when(service.queryAllUsuarios()).thenReturn(listDTO);

        mockMvc.
                perform(
                        MockMvcRequestBuilders.get("/usuarios").
                        accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(jsonPath("$[0].nome").value("nome"));
    }

    @Test
    void cadastrar() throws Exception {
        Usuario_dto dto = new Usuario_dto();
        dto.setNome("nome");
        dto.setId(Long.valueOf(1));

        Mockito.when(service.save(dto)).thenReturn(dto);
        Gson gson = new Gson();
        String json = gson.toJson(dto);


        mockMvc.
                perform(
                        MockMvcRequestBuilders.get("/usuarios").
                                accept(MediaType.APPLICATION_JSON).content(json)).
                andExpect(status().isOk());
    }
}