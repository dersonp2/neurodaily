package br.com.neurodaily.service;

import br.com.neurodaily.model.domain.Profissao;
import br.com.neurodaily.model.domain.Sexo;
import br.com.neurodaily.repository.ProfissaoRepository;
import br.com.neurodaily.repository.SexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SexoService {

    @Autowired
    private SexoRepository sexoRepository;


    @Transactional
    public Sexo salvar(Sexo sexo) {
        Sexo notaAvaliacaoBusca = buscarSexoDescricao(sexo.getDescricao());
        if (notaAvaliacaoBusca != null) {
            sexo = notaAvaliacaoBusca;
        } else {
            sexo = sexoRepository.save(sexo);
        }
        return sexo;
    }

    public Sexo buscarSexo(Long id) {
        Sexo notaAvaliacaoBusca = sexoRepository.findById(id.longValue());
        return notaAvaliacaoBusca;
    }

    public Sexo buscarSexoDescricao(String descricao) {
        Sexo notaAvaliacaoBusca = sexoRepository.findByDescricao(descricao);
        return notaAvaliacaoBusca;
    }

}

