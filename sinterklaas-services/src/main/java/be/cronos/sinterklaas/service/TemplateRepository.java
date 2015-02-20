package be.cronos.sinterklaas.service;

import be.cronos.sinterklaas.domain.TemplateEntity;

import java.util.List;

public interface TemplateRepository {
  List<TemplateEntity> getAll();
}
