package be.cronos.sinterklaas.repository;

import be.cronos.sinterklaas.domain.LetterEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class LetterRepositoryImpl implements LetterRepository {

    private static final String GET_ALL = "SELECT l FROM LetterEntity l";
    private static final String GET_ONE = "SELECT l FROM LetterEntity l WHERE id = :id";

    @PersistenceContext(unitName = "sinterklaasPU")
    private EntityManager em;


    @Override
    public List<LetterEntity> getAll() {
        Query query = em.createQuery(GET_ALL);

        return query.getResultList();
    }

    @Override
    public LetterEntity getOne(Long id) {
        final Query query = em.createQuery(GET_ONE);
        query.setParameter("id", id);
        return (LetterEntity) query.getSingleResult();
    }

}
