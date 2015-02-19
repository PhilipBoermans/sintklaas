package be.cronos.sinterklaas.service.repository;

import be.cronos.sinterklaas.service.domain.TemplateEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TemplateRepositoryImpl implements TemplateRepository {

  @PersistenceContext(unitName = "sinterklaasPU")
  protected EntityManager em;

  @Override
  public List<TemplateEntity> getAll() {
    Query query = em.createQuery("SELECT t FROM TemplateEntity t");
    return query.getResultList();
  }
}
