package br.com.neurodaily.repository;

import br.com.neurodaily.model.domain.DocumentoPessoal;
import br.com.neurodaily.model.domain.NotaAvaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoPessoalRepository extends JpaRepository<DocumentoPessoal, Long> {

    DocumentoPessoal findById(long id);
    DocumentoPessoal findByCpf(String cpf);
}
