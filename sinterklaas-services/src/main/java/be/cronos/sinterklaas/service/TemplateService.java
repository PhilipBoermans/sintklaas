package be.cronos.sinterklaas.service;


import be.cronos.sinterklaas.domain.LetterEntity;
import be.cronos.sinterklaas.domain.TemplateEntity;

import java.util.List;

public interface TemplateService {
  List<LetterEntity> getAllLetters();
  List<TemplateEntity> getAllTemplates();
}
