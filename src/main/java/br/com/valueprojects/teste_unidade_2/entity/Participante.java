package br.com.valueprojects.teste_unidade_2.entity;

public class Participante {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    private int id;
    private String nome;
    private Endereco endereco;

    private class Endereco {
        private String cep;
        private String logradouro;
        private String numero;
    }
}
