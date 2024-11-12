package br.com.valueprojects.teste_unidade_2.repository;

import br.com.valueprojects.teste_unidade_2.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Jogo_Repository extends JpaRepository<Jogo, Long> {
}
