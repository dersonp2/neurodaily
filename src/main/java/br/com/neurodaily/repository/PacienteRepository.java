package br.com.neurodaily.repository;

import br.com.neurodaily.model.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findById(long id);
}
