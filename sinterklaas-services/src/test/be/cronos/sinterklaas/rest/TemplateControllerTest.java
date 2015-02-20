package be.cronos.sinterklaas.rest;


import be.cronos.sinterklaas.domain.LetterEntity;
import be.cronos.sinterklaas.domain.TemplateEntity;
import be.cronos.sinterklaas.service.TemplateService;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TemplateControllerTest {

  private TemplateController templateController;
  private TemplateService templateService;

  @Before
  public void setUp() throws Exception {
    this.templateService = mock(TemplateService.class);
    this.templateController = new TemplateController(templateService);
  }


  @Test
  public void testGetAllLetters() {
    List<LetterEntity> expectedResult = new ArrayList<LetterEntity>();
    when(templateService.getAllLetters()).thenReturn(expectedResult);

    List<LetterEntity> result = templateController.getLetters();

    Assertions.assertThat(result).isEqualTo(expectedResult);
    verify(templateService).getAllLetters();
  }

  @Test
  public void testGetAllTemplates() {
    List<TemplateEntity> expectedResult = new ArrayList<TemplateEntity>();
    when(templateService.getAllTemplates()).thenReturn(expectedResult);

    List<TemplateEntity> result = templateController.getTemplates();

    Assertions.assertThat(result).isEqualTo(expectedResult);
    verify(templateService).getAllTemplates();
  }
}