package br.com.neurodaily.service;

import br.com.neurodaily.model.domain.Contato;
import br.com.neurodaily.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;


    @Transactional
    public Contato salvar(Contato contato) {
        return contatoRepository.save(contato);
    }
}
