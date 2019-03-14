package br.com.neurodaily.service;

import br.com.neurodaily.model.domain.DocumentoPessoal;
import br.com.neurodaily.model.domain.Pessoa;
import br.com.neurodaily.repository.DocumentoPessoalRepository;
import br.com.neurodaily.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private DocumentoPessoalService documentoPessoalService;

    @Autowired
    private SexoService sexoService;

    @Transactional
    public Pessoa salvar(Pessoa pessoa) {
//        if (pessoa != null
//                && pessoa.getDocumentoPessoal() != null
//                && pessoa.getDocumentoPessoal().getId() == null) {
//            //Cadastrar Doc Pessoal
//            pessoa.setDocumentoPessoal(documentoPessoalService.salvar(pessoa.getDocumentoPessoal()));
//        }
        if (pessoa != null
                && pessoa.getSexo() != null
                && pessoa.getSexo().getId() == null) {
            pessoa.setSexo(sexoService.salvar(pessoa.getSexo()));
        }
        pessoa = pessoaRepository.save(pessoa);

        return pessoa;

    }

    public Pessoa buscarPessoa(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id.longValue());
        return pessoa;
    }

}
