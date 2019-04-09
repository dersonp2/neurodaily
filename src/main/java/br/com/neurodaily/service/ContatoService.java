package br.com.neurodaily.service;

import br.com.neurodaily.model.domain.Contato;
import br.com.neurodaily.repository.ContatoRepository;
import br.com.neurodaily.repository.TipoContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private TipoContatoRepository tipoContatoRepository;


    @Transactional
    public Contato salvar(Contato contato) {
        if(contato.getTipoContato() != null &&
        contato.getTipoContato().getId() == null){
            contato.setTipoContato(tipoContatoRepository.save(contato.getTipoContato()));
        }
        return contatoRepository.save(contato);
    }
}
