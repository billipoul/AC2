package br.com.valueprojects.teste_unidade_2.repository;

import br.com.valueprojects.teste_unidade_2.entity.Jogo;
import br.com.valueprojects.teste_unidade_2.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Usuario_Repository extends JpaRepository<Usuario, Long> {
}
