package be.cronos.sinterklaas.service;

import be.cronos.sinterklaas.domain.LetterEntity;
import be.cronos.sinterklaas.repository.LetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

  @Autowired
  private LetterRepository templateRepository;


  @Override
  public List<LetterEntity> getAll() {
    return templateRepository.getAll();
  }
}
