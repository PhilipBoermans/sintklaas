package be.cronos.sinterklaas.repository;

import be.cronos.sinterklaas.domain.TemplateEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TemplateRepositoryImpl implements TemplateRepository {

    private static final String GET_ALL = "SELECT t FROM TemplateEntity t";
    private static final String GET_ONE = "SELECT t FROM TemplateEntity t WHERE t.id = :id";

    @PersistenceContext(unitName = "sinterklaasPU")
    private EntityManager em;

    @Override
    public List<TemplateEntity> getAll() {
        Query query = em.createQuery(GET_ALL);

        return query.getResultList();
    }

    @Override
    public TemplateEntity getOne(final Long id) {
        final Query query = em.createQuery(GET_ONE);
        query.setParameter("id", id);
        return (TemplateEntity) query.getSingleResult();
    }

}
