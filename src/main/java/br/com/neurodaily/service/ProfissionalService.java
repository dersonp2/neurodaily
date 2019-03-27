package br.com.neurodaily.service;

import br.com.neurodaily.model.domain.Paciente;
import br.com.neurodaily.model.domain.Profissao;
import br.com.neurodaily.model.domain.Profissional;
import br.com.neurodaily.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfissionalService {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private ProfissaoService profissaoService;

    @Transactional
    public Profissional salvar(Profissional profissional) {
//        if (profissional != null
//                && profissional.getPessoa() != null
//                && profissional.getPessoa().getId() == null) {
//            profissional.setPessoa(pessoaService.salvar(profissional.getPessoa()));
//        }
        if (profissional != null
                && profissional.getProfissao() != null
                && profissional.getProfissao().getId() == null) {
            profissional.setProfissao(profissaoService.salvar(profissional.getProfissao()));
        }
        profissional = profissionalRepository.save(profissional);
        return profissional;
    }

    public Profissional buscarProfissionalId(Long id) {
        Profissional profissional = profissionalRepository.findById(id.longValue());
        return profissional;
    }


}

