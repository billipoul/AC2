package br.com.valueprojects.teste_unidade_2.model;

import br.com.valueprojects.teste_unidade_2.repository.Jogo_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jogo {
	private String descricao;
	private List<Resultado> resultados;

	public Jogo(String descricao) {
		this.descricao = descricao;
		this.resultados = new ArrayList<Resultado>();
	}

	public void anota(Resultado resultado) {
		if (resultados.isEmpty()
				|| !resultados.get(ultimoResultadoVisto()).getParticipante().equals(resultado.getParticipante())) {
			resultados.add(resultado);
		}

	}

	private int ultimoResultadoVisto() {
		return resultados.size() - 1;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Resultado> getResultados() {
		return Collections.unmodifiableList(resultados);
	}

}
