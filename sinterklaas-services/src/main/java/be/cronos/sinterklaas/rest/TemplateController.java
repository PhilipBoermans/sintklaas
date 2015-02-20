package be.cronos.sinterklaas.rest;

import be.cronos.sinterklaas.domain.LetterEntity;
import be.cronos.sinterklaas.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class TemplateController {

  @Autowired
  private TemplateService templateService;

  @RequestMapping(value = "/letters/all", produces = "application/json")
  public List<LetterEntity> getLetters() {
    return templateService.getAll();
  }
}
