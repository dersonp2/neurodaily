package br.com.neurodaily.repository;

import br.com.neurodaily.model.domain.Profissao;
import br.com.neurodaily.model.domain.Sexo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SexoRepository extends JpaRepository<Sexo, Long> {

    Sexo findById(long id);
    Sexo findByDescricao(String descricao);
}
