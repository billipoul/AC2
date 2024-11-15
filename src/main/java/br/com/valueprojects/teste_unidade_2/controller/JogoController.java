package br.com.valueprojects.teste_unidade_2.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.valueprojects.teste_unidade_2.dto.Jogo_dto;
import br.com.valueprojects.teste_unidade_2.repository.Jogo_Repository;
import br.com.valueprojects.teste_unidade_2.service.Jogo_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.valueprojects.teste_unidade_2.model.Jogo;
import br.com.valueprojects.teste_unidade_2.model.Juiz;

@RestController
@CrossOrigin
@RequestMapping("/jogos")
public class JogoController {

	@Autowired
	private Jogo_service service;

	@GetMapping
	public List<Jogo_dto> listar() {
		return service.queryAllJogos();
	}

	@PostMapping
	public Jogo_dto cadastrar(@RequestBody Jogo_dto jogo) {
		return service.save(jogo);
	}

}
