package br.com.valueprojects.teste_unidade_2.controller;

import br.com.valueprojects.teste_unidade_2.dto.Usuario_dto;
import br.com.valueprojects.teste_unidade_2.model.Jogo;
import br.com.valueprojects.teste_unidade_2.model.Juiz;
import br.com.valueprojects.teste_unidade_2.service.Jogo_service;
import br.com.valueprojects.teste_unidade_2.service.Usuario_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private Usuario_service service;

	@GetMapping
	public List<Usuario_dto> listar() {
		return service.queryAllUsuarios();
	}

	@PostMapping
	public Usuario_dto cadastrar(@RequestBody Usuario_dto dto) {
		return service.save(dto);
	}

	@PostMapping("/upgrade")
	public Usuario_dto upgradeUsuario(@RequestBody Usuario_dto dto) {
		return service.upgrade(dto.getId());
	}

}
