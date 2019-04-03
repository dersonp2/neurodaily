package br.com.neurodaily.repository;

import br.com.neurodaily.model.domain.Paciente;
import br.com.neurodaily.repository.query.PacienteRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long>, PacienteRepositoryQuery {

    Paciente findById(long id);


}
