package be.cronos.sinterklaas.service;

import be.cronos.sinterklaas.domain.TemplateEntity;
import be.cronos.sinterklaas.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

  @Autowired
  private TemplateRepository templateRepository;


  @Override
  public List<TemplateEntity> getAll() {
    return templateRepository.getAll();
  }
}
