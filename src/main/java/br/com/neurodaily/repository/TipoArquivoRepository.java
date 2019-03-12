package br.com.neurodaily.repository;

import br.com.neurodaily.model.domain.Profissao;
import br.com.neurodaily.model.domain.TipoArquivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoArquivoRepository extends JpaRepository<TipoArquivo, Long> {

    TipoArquivo findByDescricao(String descricao);
    TipoArquivo findById (long id);
}
