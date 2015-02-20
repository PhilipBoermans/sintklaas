package be.cronos.sinterklaas.service.utility;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ReportLoader {

    @Autowired
    private ResourceLoader resourceLoader;

    public JasperReport loadReport(final String reportName) {
        try {
            return JasperCompileManager.compileReport(
                    resourceLoader.getResource(reportName).getInputStream()
            );
        } catch (JRException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
