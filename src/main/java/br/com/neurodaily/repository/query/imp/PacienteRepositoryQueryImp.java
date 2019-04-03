package br.com.neurodaily.repository.query.imp;

import br.com.neurodaily.model.domain.Paciente;
import br.com.neurodaily.repository.query.PacienteRepositoryQuery;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PacienteRepositoryQueryImp implements PacienteRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public int countByFilter(String filtro) {
        return 0;
    }

    @Override
    public List<Paciente> filtrar(String filtro) {
        return manager.createQuery(createStringQueryForResultList(filtro, true), Paciente.class).getResultList();
    }

    private String createStringQueryForResultList(String filtro, boolean count) {
        StringBuilder builder = new StringBuilder();

        builder.append("select new br.com.neurodaily.model.domain.Paciente")
                .append(" (pa.id, pa.matricula, pe.nome)")
                .append(" from paciente AS pa")
                .append(" INNER JOIN pessoa AS pe ON pa.pessoa.id = pe.id");

        if (!StringUtils.isEmpty(filtro)) {
            builder.append(" where (pe.nome like'%").append(filtro).append("%'");
        }

        builder.append(count ? "" : " order by pe.nome");

        return builder.toString();
    }
}
