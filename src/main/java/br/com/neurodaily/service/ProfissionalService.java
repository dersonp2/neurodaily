package br.com.neurodaily.service;

import br.com.neurodaily.model.domain.Paciente;
import br.com.neurodaily.model.domain.PessoaContato;
import br.com.neurodaily.model.domain.Profissao;
import br.com.neurodaily.model.domain.Profissional;
import br.com.neurodaily.model.helper.ProfissionalHelper;
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

    @Autowired
    private PessoaContatoService pessoaContatoService;

    @Autowired
    private DocumentoPessoalService documentoPessoalService;

    @Transactional
    public Profissional salvar(ProfissionalHelper profissionalHelper) {
        if (profissionalHelper != null
                && profissionalHelper.getProfissional().getPessoa() != null
                && profissionalHelper.getProfissional().getPessoa().getId() == null) {
            profissionalHelper.getProfissional().setPessoa(pessoaService.salvar
                    (profissionalHelper.getProfissional().getPessoa()));
        }
        if (profissionalHelper != null
                && profissionalHelper.getProfissional().getProfissao() != null
                && profissionalHelper.getProfissional().getProfissao().getId() == null) {
            profissionalHelper.getProfissional().setProfissao
                    (profissaoService.salvar(profissionalHelper.getProfissional().getProfissao()));
        }
        if (profissionalHelper != null &&
                profissionalHelper.getDocumentoPessoal() != null &&
                profissionalHelper.getDocumentoPessoal().getId() == null) {
            profissionalHelper.getDocumentoPessoal().setPessoa(profissionalHelper.getProfissional().getPessoa());
            profissionalHelper.setDocumentoPessoal(documentoPessoalService.salvar(profissionalHelper.getDocumentoPessoal()));
        }
        if (profissionalHelper != null
                && profissionalHelper.getPessoaContatos() != null
                && !profissionalHelper.getPessoaContatos().isEmpty()) {

            for (PessoaContato pessoaContato : profissionalHelper.getPessoaContatos()) {
                pessoaContato.setPessoa(profissionalHelper.getProfissional().getPessoa());
                pessoaContatoService.salvar(pessoaContato);
            }
        }

       Profissional profissional = profissionalRepository.save
               (profissionalHelper.getProfissional());
        return profissional;
    }

    public Profissional buscarProfissionalId(Long id) {
        Profissional profissional = profissionalRepository.findById(id.longValue());
        return profissional;
    }


}

