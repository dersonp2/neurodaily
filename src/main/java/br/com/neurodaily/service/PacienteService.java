package br.com.neurodaily.service;

import br.com.neurodaily.model.domain.DocumentoPessoal;
import br.com.neurodaily.model.domain.Paciente;
import br.com.neurodaily.model.domain.Pessoa;
import br.com.neurodaily.model.domain.PessoaContato;
import br.com.neurodaily.model.helper.PacienteHelper;
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

    @Autowired
    private DocumentoPessoalService documentoPessoalService;

    @Autowired
    private PessoaContatoService pessoaContatoService;


    @Transactional
    public Paciente salvar(PacienteHelper pacienteHelper) {
        if (pacienteHelper != null
                && pacienteHelper.getPaciente().getPessoa() != null
                && pacienteHelper.getPaciente().getPessoa().getId() == null) {
            pacienteHelper.getPaciente().setPessoa(pessoaService.salvar(pacienteHelper.getPaciente().getPessoa()));
        }

        if (pacienteHelper != null &&
                pacienteHelper.getDocumentoPessoal() != null &&
                pacienteHelper.getDocumentoPessoal().getId() == null) {
            pacienteHelper.getDocumentoPessoal().setPessoa(pacienteHelper.getPaciente().getPessoa());
            pacienteHelper.setDocumentoPessoal(documentoPessoalService.salvar(pacienteHelper.getDocumentoPessoal()));
        }

//        if (pacienteHelper != null
//                && pacienteHelper.getPessoaContatos() != null
//                && !pacienteHelper.getPessoaContatos().isEmpty()) {
//
//            for (PessoaContato pessoaContato : pacienteHelper.getPessoaContatos()) {
//                pessoaContato.setPessoa(pacienteHelper.getPaciente().getPessoa());
//                pessoaContatoService.salvar(pessoaContato);
//            }

        //}

        if (pacienteHelper != null
                && pacienteHelper.getPaciente().getResponsavel() != null
                && pacienteHelper.getPaciente().getResponsavel().getId() == null) {
            pacienteHelper.getPaciente().setResponsavel(pessoaService.salvar(pacienteHelper.getPaciente().getResponsavel()));
        }

        if (pacienteHelper != null &&
                pacienteHelper.getDocumentoPessoalResponsavel() != null &&
                pacienteHelper.getDocumentoPessoalResponsavel().getId() == null) {
            pacienteHelper.getDocumentoPessoalResponsavel().
                    setPessoa(pacienteHelper.getPaciente().getResponsavel());
            pacienteHelper.setDocumentoPessoalResponsavel
                    (documentoPessoalService.salvar(pacienteHelper.getDocumentoPessoalResponsavel()));
        }

        Paciente paciente = pacienteRepository.save(pacienteHelper.getPaciente());
        return paciente;
    }

    public Paciente buscarPacienteId(Long id) {
        Paciente paciente = pacienteRepository.findById(id.longValue());
        return paciente;
    }

}

