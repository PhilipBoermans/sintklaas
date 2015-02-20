package be.cronos.sinterklaas.service;

import be.cronos.sinterklaas.domain.TemplateEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TemplateRepositoryImpl implements TemplateRepository {

  private static final String GET_ALL = "SELECT t FROM TemplateEntity t";

  @PersistenceContext(unitName = "sinterklaasPU")
  private EntityManager em;

  @Override
  public List<TemplateEntity> getAll() {
    Query query = em.createQuery(GET_ALL);

    return query.getResultList();
  }

}
