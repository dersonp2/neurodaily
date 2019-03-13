package br.com.neurodaily.repository;

import br.com.neurodaily.model.domain.DocumentoPessoal;
import br.com.neurodaily.model.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findById(long id);
}
