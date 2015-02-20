package be.cronos.sinterklaas.service;

import be.cronos.sinterklaas.ApplicationIntegrationTest;
import be.cronos.sinterklaas.command.LetterCommand;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.fest.assertions.Assertions.assertThat;

public class LetterReportBuilderServiceIntegrationTest extends ApplicationIntegrationTest {

    @Autowired
    private LetterReportBuilderService letterReportBuilderService;

    @Test
    public void buildLetter() throws Exception {
        saveToDisk(
                letterReportBuilderService.generate(command()),
                "letter_test.pdf"
        );
    }

    private LetterCommand command() {
        final LetterCommand command = new LetterCommand();
        command.setImage(1L);
        command.setText(1L);
        return command;
    }

    private void saveToDisk(byte[] report, String fileName) {
        final String separator = File.separator;
        saveFile(
                new ByteArrayInputStream(report),
                System.getProperty("java.io.tmpdir") + separator + "poc" + separator,
                fileName
        );
    }

    private void saveFile(InputStream inputStream, String directory, String fileName) {
        final File systemDirectory = new File(directory);
        systemDirectory.mkdir();

        final File file = new File(systemDirectory, fileName);
        try (OutputStream outputStream = new FileOutputStream(file); InputStream fileStream = inputStream) {
            System.out.println("Writing file to: " + file.getAbsolutePath());
            IOUtils.copy(fileStream, outputStream);

            assertThat(file.length()).isLessThan(3500000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}