package br.com.neurodaily.repository.query;

import br.com.neurodaily.model.domain.Paciente;

import java.util.List;

public interface PacienteRepositoryQuery {

    int countByFilter(String filtro);

    List<Paciente> filtrar(String filtro);

}
