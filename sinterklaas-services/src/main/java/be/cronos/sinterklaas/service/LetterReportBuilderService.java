package be.cronos.sinterklaas.service;

import be.cronos.sinterklaas.command.LetterCommand;import be.cronos.sinterklaas.repository.LetterRepository;
import be.cronos.sinterklaas.repository.TemplateRepository;
import be.cronos.sinterklaas.service.utility.ReportLoader;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BadPdfFormatException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class LetterReportBuilderService implements LetterBuilderService {

    private static final String MASTER_REPORT = "reports/letter.jrxml";

    @Autowired
    private LetterRepository letterRepository;
    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private ReportLoader reportLoader;

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public byte[] generate(final LetterCommand command) {
        try (ByteArrayOutputStream file = new ByteArrayOutputStream()) {
            final Document document = new Document(PageSize.A4);
            final PdfCopy pdf = new PdfCopy(document, file);

            document.open();

            attach(
                    createReport(
                            createDataSource(
                                    resourceLoader.getResource(templateRepository.getOne(command.getImage()).getPath()).getInputStream(),
                                    letterRepository.getOne(command.getText()).getBody()
                            )
                    ),
                    pdf
            );

            document.close();
            pdf.close();

            return file.toByteArray();
        } catch (DocumentException | JRException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void attach(final ByteArrayOutputStream file, final PdfCopy pdf) throws IOException, BadPdfFormatException {
        final PdfReader pdfReader = new PdfReader(file.toByteArray());
        pdfReader.consolidateNamedDestinations();

        final PdfImportedPage page = pdf.getImportedPage(pdfReader, 1);
        pdf.newPage();
        pdf.addPage(page);
    }

    private ByteArrayOutputStream createReport(final Map<String, Object> dataSource) throws JRException {
        final JasperReport masterReport = reportLoader.loadReport(MASTER_REPORT);

        final JasperPrint letter = JasperFillManager.fillReport(masterReport, dataSource, new JREmptyDataSource());
        final ByteArrayOutputStream letterStream = new ByteArrayOutputStream();
        JasperExportManager.exportReportToPdfStream(letter, letterStream);

        return letterStream;
    }

    private Map<String, Object> createDataSource(final InputStream background, final String letterText) {
        final Map<String, Object> dataSourceParams = new HashMap<>();
        dataSourceParams.put("background", background);
        dataSourceParams.put("text", letterText);
        return dataSourceParams;
    }

}
