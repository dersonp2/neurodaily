package br.com.neurodaily.repository;

import br.com.neurodaily.model.domain.Avaliacao;
import br.com.neurodaily.model.domain.NotaAvaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    Avaliacao findById(long id);
}
