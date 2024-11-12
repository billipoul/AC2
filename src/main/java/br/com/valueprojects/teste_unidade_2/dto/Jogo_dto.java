package br.com.valueprojects.teste_unidade_2.dto;


import br.com.valueprojects.teste_unidade_2.entity.Jogo;
import br.com.valueprojects.teste_unidade_2.entity.Resultados;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Jogo_dto {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String descricao;

    @Getter @Setter
    private List<JogoResultados> resultados;

    public static class JogoResultados {

        @Getter @Setter
        private String id_participante;

        @Getter @Setter
        private double pontuacao;
    }

    public Jogo_dto(Long id, String descricao, List<JogoResultados> resultados) {
        this.id = id;
        this.descricao = descricao;
        this.resultados = resultados;
    }

    public Jogo_dto() {}

    public static Jogo_dto fromEntity(Jogo jogo) {
        Jogo_dto jogo_dto = new Jogo_dto();
        jogo_dto.id = jogo.getId();
        jogo_dto.descricao = jogo.getDescricao();
        jogo_dto.resultados = new ArrayList<JogoResultados>();
        List<Resultados> resultados = jogo.getResultados();
        for (Resultados resultado : resultados) {
            JogoResultados jogoResultados = new JogoResultados();
            jogoResultados.id_participante = resultado.getId_participante();
            jogoResultados.pontuacao = resultado.getPontuacao();
            jogo_dto.resultados.add(jogoResultados);
        }
        return jogo_dto;
    }

    public static Jogo toEntity(Jogo_dto jogo_dto) {
        Jogo jogo = new Jogo();
        jogo.setId(jogo_dto.id);
        jogo.setDescricao(jogo_dto.descricao);
        List<Resultados> resultados = new ArrayList<Resultados>();

        for (JogoResultados resultado : jogo_dto.resultados) {
            Resultados resultadoItem = new Resultados();
            resultadoItem.setId_participante(resultado.id_participante);
            resultadoItem.setPontuacao(resultado.pontuacao);
            resultados.add(resultadoItem);
        }
        jogo.setResultados(resultados);
        return jogo;
    }


}
