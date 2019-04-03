package br.com.neurodaily.repository;

import br.com.neurodaily.model.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Paciente findById(long id);

    @Query(value = "select *" +
            " from ND10_PACIENTE ND10" +
            " inner join ND01_PESSOA ND01" +
            " ON ND01.ND01_COD_PESSOA = ND10.FKND10ND01_COD_PESSOA" +
            " WHERE ND01.ND01_NOME LIKE '%?%' ", nativeQuery = true)
    List<Paciente> findPacienteByPessoaNome(String nome);

}
