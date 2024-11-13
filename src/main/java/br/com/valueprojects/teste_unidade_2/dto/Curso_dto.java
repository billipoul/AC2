package br.com.valueprojects.teste_unidade_2.dto;


import br.com.valueprojects.teste_unidade_2.entity.Curso;
import br.com.valueprojects.teste_unidade_2.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

public class Curso_dto {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private Long idUsuario;

    @Getter @Setter
    private Boolean completo;

    public Curso_dto(Long id, String nome, Long idUsuario) {
        this.id = id;
        this.nome = nome;
        this.idUsuario = idUsuario;
        this.completo = false;
    }

    public Curso_dto() {}

    public static Curso_dto fromEntity(Curso curso) {
        Curso_dto dto = new Curso_dto();
        dto.setId(curso.getId());
        dto.setNome(curso.getNome());
        dto.setIdUsuario(curso.getIdUsuario());
        dto.setCompleto(curso.getCompleto());
        return dto;
    }

    public static Curso toEntity(Curso_dto dto) {
        Curso curso = new Curso();
        curso.setId(dto.getId());
        curso.setNome(dto.getNome());
        curso.setIdUsuario(dto.getIdUsuario());
        curso.setCompleto(dto.getCompleto());
        return curso;
    }
}
