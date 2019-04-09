package br.com.neurodaily.repository;

import br.com.neurodaily.model.domain.Estado;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UFRepository extends JpaRepository<Estado, Long> {
    @Cacheable("Estado")
    List<Estado>  findByOrderByDescricao();

}
