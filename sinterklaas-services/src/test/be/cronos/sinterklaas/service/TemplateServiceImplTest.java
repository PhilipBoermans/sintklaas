package be.cronos.sinterklaas.service;

import be.cronos.sinterklaas.domain.LetterEntity;
import be.cronos.sinterklaas.repository.LetterRepository;
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

  @Before
  public void setUp() throws Exception {
    this.letterRepository = mock(LetterRepository.class);
    this.templateService = new TemplateServiceImpl(letterRepository);
  }

  @Test
  public void testGetAll() {
    List<LetterEntity> expectedResult = new ArrayList<LetterEntity>();
    when(letterRepository.getAll()).thenReturn(expectedResult);

    List<LetterEntity> result = templateService.getAll();

    Assertions.assertThat(result).isEqualTo(expectedResult);
  }
  
}