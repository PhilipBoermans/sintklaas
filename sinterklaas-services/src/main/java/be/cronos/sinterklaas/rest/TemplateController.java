package be.cronos.sinterklaas.rest;

import be.cronos.sinterklaas.domain.LetterEntity;
import be.cronos.sinterklaas.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController()
public class TemplateController {

  private TemplateService templateService;

  @Autowired
  public TemplateController(TemplateService templateService) {
    this.templateService = templateService;
  }


  @RequestMapping(value = "/letters/all", produces = "application/json")
  public List<LetterEntity> getLetters(HttpServletResponse response) {
    response.addHeader("Access-Control-Allow-Origin", "*");
    return templateService.getAll();
  }
}
