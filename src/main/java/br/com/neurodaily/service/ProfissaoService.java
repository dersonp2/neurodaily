package br.com.neurodaily.service;

import br.com.neurodaily.model.domain.Profissao;
import br.com.neurodaily.repository.ProfissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfissaoService {

    @Autowired
    private ProfissaoRepository profissaoRepository;


    @Transactional
    public Profissao salvar(Profissao profissao) {
        Profissao profissaoBusca = buscarProfissaoNome(profissao);
        if (profissaoBusca != null) {
            profissao = profissaoBusca;
        } else {
            profissao = profissaoRepository.save(profissao);
        }

        return profissao;
    }

    private Profissao buscarProfissaoNome(Profissao profissao) {
        Profissao profissaoBusca = null;
        if (profissao != null && profissao.getDescricao() != null) {
            profissaoBusca = profissaoRepository
                    .findByDescricao(profissao.getDescricao());
        }
        return profissaoBusca;
    }
}

