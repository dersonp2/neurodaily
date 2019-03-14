package br.com.neurodaily.repository;

import br.com.neurodaily.model.domain.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
