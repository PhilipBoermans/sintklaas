package be.cronos.sinterklaas.service;


import be.cronos.sinterklaas.service.domain.TemplateEntity;

import java.util.List;

public interface TemplateService {
  List<TemplateEntity> getAll();
}
