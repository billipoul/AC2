package br.com.valueprojects.teste_unidade_2.controller;

import br.com.valueprojects.teste_unidade_2.dto.Curso_dto;
import br.com.valueprojects.teste_unidade_2.service.Curso_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private Curso_service service;

	@GetMapping
	public List<Curso_dto> listar() {
		return service.queryAllCursos();
	}

	@PostMapping
	public Curso_dto cadastrar(@RequestBody Curso_dto dto) {
		return service.save(dto);
	}

	@PostMapping("/completar")
	public Curso_dto completaCurso(@RequestBody long id) {
		return service.completar(id);
	}

}
