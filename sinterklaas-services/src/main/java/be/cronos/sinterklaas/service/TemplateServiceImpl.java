package be.cronos.sinterklaas.service;

import be.cronos.sinterklaas.domain.LetterEntity;
import be.cronos.sinterklaas.repository.LetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

  private LetterRepository letterRepository;

  @Autowired
  public TemplateServiceImpl(LetterRepository letterRepository){
    this.letterRepository = letterRepository;
  }


  @Override
  public List<LetterEntity> getAll() {
    return letterRepository.getAll();
  }
}
