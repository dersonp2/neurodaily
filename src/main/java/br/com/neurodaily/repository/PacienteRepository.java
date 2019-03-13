package br.com.neurodaily.repository;

        import br.com.neurodaily.model.domain.Paciente;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Paciente findById(long id);

    Paciente findByPessoaDocumentoPessoalCpf(String cpf);
}
