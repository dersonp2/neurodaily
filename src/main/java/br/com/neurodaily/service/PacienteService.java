package br.com.neurodaily.service;

import br.com.neurodaily.model.domain.Paciente;
import br.com.neurodaily.model.domain.Pessoa;
import br.com.neurodaily.repository.PacienteRepository;
import br.com.neurodaily.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteService {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
    public Paciente salvar(Paciente paciente) {
        if (paciente != null
                && paciente.getPessoa() != null
                && paciente.getPessoa().getId() == null) {
            paciente.setPessoa(pessoaService.salvar(paciente.getPessoa()));
        }
        if (paciente != null
                && paciente.getResponsavel() != null
                && paciente.getResponsavel().getId() == null) {
            paciente.setResponsavel(pessoaService.salvar(paciente.getResponsavel()));
        }
        paciente = pacienteRepository.save(paciente);
        return paciente;
    }

    public Paciente buscarPacienteId(Long id) {
        Paciente paciente = pacienteRepository.findById(id.longValue());
        return paciente;
    }

}

