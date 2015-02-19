package be.cronos.sinterklaas.rest;

import be.cronos.sinterklaas.domain.TemplateEntity;
import be.cronos.sinterklaas.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class TemplateController {

  @Autowired
  private TemplateService templateService;

  @RequestMapping(value = "/templates/all", produces = "application/json")
  public List<TemplateEntity> getTemplates() {
    return templateService.getAll();
  }
}
