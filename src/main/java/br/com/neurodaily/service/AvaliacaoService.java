package br.com.neurodaily.service;

import br.com.neurodaily.model.domain.Avaliacao;
import br.com.neurodaily.model.domain.NotaAvaliacao;
import br.com.neurodaily.repository.AvaliacaoRepository;
import br.com.neurodaily.repository.NotaAvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private NotaAvaliacaoService notaAvaliacaoService;


    @Transactional
    public Avaliacao salvar(Avaliacao avaliacao) {
        if(avaliacao != null &&
        avaliacao.getNotaAvaliacao() != null &&
        avaliacao.getNotaAvaliacao().getId() == null){
                avaliacao.setNotaAvaliacao(notaAvaliacaoService.salvar(avaliacao.getNotaAvaliacao()));
        }
        
        return avaliacao;
    }

    public Avaliacao buscarNotaAvaliacao(Long id) {
        Avaliacao notaAvaliacaoBusca = avaliacaoRepository.findById(id.longValue());
        return notaAvaliacaoBusca;
    }
}

