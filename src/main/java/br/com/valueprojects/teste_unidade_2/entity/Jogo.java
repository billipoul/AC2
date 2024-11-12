package br.com.valueprojects.teste_unidade_2.entity;

import br.com.valueprojects.teste_unidade_2.model.Resultado;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tb_jogo")
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter
    @Setter
    private String descricao;

    @Getter
    @Setter
    @ElementCollection
    private List<Resultados> resultados;

    public Jogo() {
        this.descricao = "";
        this.resultados = new ArrayList<Resultados>();
    }
}


