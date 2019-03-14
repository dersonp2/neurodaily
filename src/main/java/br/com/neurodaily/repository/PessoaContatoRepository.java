package br.com.neurodaily.repository;

import br.com.neurodaily.model.domain.PessoaContato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaContatoRepository extends JpaRepository<PessoaContato, Long> {
}
