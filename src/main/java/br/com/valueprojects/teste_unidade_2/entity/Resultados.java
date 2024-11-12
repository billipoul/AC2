package br.com.valueprojects.teste_unidade_2.entity;

import br.com.valueprojects.teste_unidade_2.model.Resultado;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Embeddable
public class Resultados {
    @Getter
    @Setter
    private String id_participante;

    @Getter
    @Setter
    private double pontuacao;
}
