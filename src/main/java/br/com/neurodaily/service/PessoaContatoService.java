package br.com.neurodaily.service;

import br.com.neurodaily.model.domain.Contato;
import br.com.neurodaily.model.domain.PessoaContato;
import br.com.neurodaily.repository.ContatoRepository;
import br.com.neurodaily.repository.PessoaContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoaContatoService {

    @Autowired
    private PessoaContatoRepository pessoaContatoRepository;

    @Autowired
    private ContatoService contatoService;


    @Transactional
    public PessoaContato salvar(PessoaContato pessoaContato) {

        if (pessoaContato != null
                && pessoaContato.getContato() != null
                && pessoaContato.getContato().getId() == null) {

            pessoaContato.setContato(contatoService.salvar(pessoaContato.getContato()));
        }

        return pessoaContatoRepository.save(pessoaContato);
    }
}
