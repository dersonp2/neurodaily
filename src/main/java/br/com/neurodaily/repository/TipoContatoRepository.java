package br.com.neurodaily.repository;

import br.com.neurodaily.model.domain.Contato;
import br.com.neurodaily.model.domain.TipoContato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoContatoRepository extends JpaRepository<TipoContato, Long> {
    TipoContato findById(long id);
}
