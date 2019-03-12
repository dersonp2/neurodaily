package br.com.neurodaily.service;

import br.com.neurodaily.model.domain.NotaAvaliacao;
import br.com.neurodaily.model.domain.Profissao;
import br.com.neurodaily.repository.NotaAvaliacaoRepository;
import br.com.neurodaily.repository.ProfissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotaAvaliacaoService {

    @Autowired
    private NotaAvaliacaoRepository notaAvaliacaoRepository;


    @Transactional
    public NotaAvaliacao salvar(NotaAvaliacao notaAvaliacao) {
        NotaAvaliacao notaAvaliacaoBusca = buscarNotaAvaliacao(notaAvaliacao.getId());
        if (notaAvaliacaoBusca != null) {
            notaAvaliacao = notaAvaliacaoBusca;
        } else {
            notaAvaliacao = notaAvaliacaoRepository.save(notaAvaliacao);
        }

        return notaAvaliacao;
    }

    public NotaAvaliacao buscarNotaAvaliacao(Long id) {
        NotaAvaliacao notaAvaliacaoBusca = notaAvaliacaoRepository.findById(id.longValue());
        return notaAvaliacaoBusca;
    }
}

