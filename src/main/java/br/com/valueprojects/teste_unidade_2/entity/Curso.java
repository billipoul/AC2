package br.com.valueprojects.teste_unidade_2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tb_curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter
    @Setter
    private String nome;

    @Getter @Setter
    private Long idUsuario;

    @Getter @Setter
    private Boolean completo;

    public Curso() {}
}


