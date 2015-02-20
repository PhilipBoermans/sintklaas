package be.cronos.sinterklaas.service.utility;

import be.cronos.sinterklaas.ApplicationIntegrationTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import static org.fest.assertions.Assertions.assertThat;

public class ReportLoaderTest extends ApplicationIntegrationTest {

    @Autowired
    ReportLoader reportLoader;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void canLoadReport() {
        assertThat(reportLoader.loadReport("reports/letter.jrxml")).isNotNull();
    }

    @Test
    public void throwsRuntimeExceptionWhenReportNotFound() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("java.io.FileNotFoundException: class path resource [letter.jrxml] cannot be opened because it does not exist");
        reportLoader.loadReport("letter.jrxml");
    }

}