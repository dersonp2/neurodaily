package br.com.neurodaily.repository;

import br.com.neurodaily.model.domain.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfissaoRepository extends JpaRepository<Profissao, Long> {

    Profissao findByDescricao(String descricao);

    Profissao findById(long id);

    List<Profissao> findAllByOrderByDescricao();
}
