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

    @Autowired
    private ProfissionalService profissionalService;

    @Autowired
    private PacienteService pacienteService;


    @Transactional
    public Avaliacao salvar(Avaliacao avaliacao) {
        if (avaliacao != null) {
            if (avaliacao.getNotaAvaliacao() != null &&
                    avaliacao.getNotaAvaliacao().getId() == null) {
                avaliacao.setNotaAvaliacao(notaAvaliacaoService.salvar(avaliacao.getNotaAvaliacao()));
            }
//            if (avaliacao.getProfissional() != null &&
//                    avaliacao.getProfissional().getId() == null) {
//                avaliacao.setProfissional(profissionalService.salvar(avaliacao.getProfissional()));
//            }

//            if (avaliacao.getPaciente() != null &&
//                    avaliacao.getPaciente().getId() == null) {
//                avaliacao.setPaciente(pacienteService.salvar(avaliacao.getPaciente()));
//            }
        }
        avaliacao = avaliacaoRepository.save(avaliacao);
        return avaliacao;
    }

    public Avaliacao buscarAvaliacao(Long id) {
        Avaliacao avaliacaoBusca = avaliacaoRepository.findById(id.longValue());
        return avaliacaoBusca;
    }
}

