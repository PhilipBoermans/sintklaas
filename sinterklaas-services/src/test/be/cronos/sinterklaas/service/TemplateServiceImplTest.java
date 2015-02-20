package be.cronos.sinterklaas.service;

import be.cronos.sinterklaas.domain.LetterEntity;
import be.cronos.sinterklaas.domain.TemplateEntity;
import be.cronos.sinterklaas.repository.LetterRepository;
import be.cronos.sinterklaas.repository.TemplateRepository;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TemplateServiceImplTest {

  private TemplateService templateService;
  private LetterRepository letterRepository;
  private TemplateRepository templateRepository;

  @Before
  public void setUp() throws Exception {
    this.letterRepository = mock(LetterRepository.class);
    this.templateRepository = mock(TemplateRepository.class);
    this.templateService = new TemplateServiceImpl(letterRepository, templateRepository);
  }

  @Test
  public void testGetAllLetters() {
    List<LetterEntity> expectedResult = new ArrayList<LetterEntity>();
    when(letterRepository.getAll()).thenReturn(expectedResult);

    List<LetterEntity> result = templateService.getAllLetters();

    Assertions.assertThat(result).isEqualTo(expectedResult);
  }

  @Test
  public void testGetAllTemplates() {
    List<TemplateEntity> expectedResult = new ArrayList<TemplateEntity>();
    when(templateRepository.getAll()).thenReturn(expectedResult);

    List<TemplateEntity> result = templateService.getAllTemplates();

    Assertions.assertThat(result).isEqualTo(expectedResult);
  }
  
}