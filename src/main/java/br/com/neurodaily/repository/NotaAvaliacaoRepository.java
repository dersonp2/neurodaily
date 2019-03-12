package br.com.neurodaily.repository;

import br.com.neurodaily.model.domain.NotaAvaliacao;
import br.com.neurodaily.model.domain.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaAvaliacaoRepository extends JpaRepository<NotaAvaliacao, Long> {

    NotaAvaliacao findById(long id);
}
