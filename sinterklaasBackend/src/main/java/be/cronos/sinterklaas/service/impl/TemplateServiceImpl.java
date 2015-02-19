package be.cronos.sinterklaas.service.impl;

import be.cronos.sinterklaas.service.TemplateService;
import be.cronos.sinterklaas.service.domain.TemplateEntity;
import be.cronos.sinterklaas.service.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

  private TemplateRepository templateRepository;

  @Autowired
  public TemplateServiceImpl(TemplateRepository templateRepository) {
    this.templateRepository = templateRepository;
  }

  @Override
  public List<TemplateEntity> getAll() {
    return templateRepository.getAll();
  }
}
