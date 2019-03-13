package br.com.neurodaily.repository;

import br.com.neurodaily.model.domain.NotaAvaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<NotaAvaliacao, Long> {

    NotaAvaliacao findById(long id);
}
