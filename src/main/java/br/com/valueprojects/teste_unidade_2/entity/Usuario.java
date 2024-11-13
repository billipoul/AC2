package br.com.valueprojects.teste_unidade_2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter
    @Setter
    private String nome;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String papel;

    public Usuario() {}
}


