package br.com.neurodaily.repository;

import br.com.neurodaily.model.domain.Cidade;
import org.hibernate.service.spi.ServiceException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MunicipioRepository extends JpaRepository<Cidade, Long> {
    @Cacheable("Cidade")
    List<Cidade> findByEstado_Id(Long id) throws ServiceException;
}
