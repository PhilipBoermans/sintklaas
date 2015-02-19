package be.cronos.sinterklaas.service.repository;


import be.cronos.sinterklaas.service.domain.TemplateEntity;

import java.util.List;

public interface TemplateRepository {
  public List<TemplateEntity> getAll();
}
