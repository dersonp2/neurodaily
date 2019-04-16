package br.com.neurodaily.repository;

import br.com.neurodaily.model.domain.Paciente;
import br.com.neurodaily.model.domain.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

    Profissional findById(long id);
}
