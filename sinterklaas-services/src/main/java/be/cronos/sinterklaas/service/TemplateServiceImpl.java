package be.cronos.sinterklaas.service;

import be.cronos.sinterklaas.domain.LetterEntity;
import be.cronos.sinterklaas.domain.TemplateEntity;
import be.cronos.sinterklaas.repository.LetterRepository;
import be.cronos.sinterklaas.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

  private LetterRepository letterRepository;
  private TemplateRepository templateRepository;

  @Autowired
  public TemplateServiceImpl(LetterRepository letterRepository, TemplateRepository templateRepository){
    this.letterRepository = letterRepository;
    this.templateRepository = templateRepository;
  }


  @Override
  public List<LetterEntity> getAllLetters() {
    return letterRepository.getAll();
  }

  @Override
  public List<TemplateEntity> getAllTemplates() {
    return templateRepository.getAll();
  }
}
