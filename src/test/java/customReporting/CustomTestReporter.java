package customReporting;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.reporters.IReporterConfig;
import org.testng.xml.XmlSuite;

import java.io.*;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public class CustomTestReporter implements IReporter {

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        PrintWriter reportWriter = null;
        File reportFile = new File("target/customReport" + +Instant.now().getEpochSecond() + ".html");

        try(FileWriter fileWriter = new FileWriter(reportFile)){
            reportWriter = new PrintWriter(new BufferedWriter(new FileWriter(reportFile)));
        }
        catch (IOException exception){
            exception.printStackTrace();
        }

        if (reportWriter == null){
            return;
        }

        reportWriter.println("<!DOCTYPE html>");
        reportWriter.println("<html>");
        reportWriter.println("<head>");
        reportWriter.println("</head>");
        reportWriter.println("<body>");
        for (ISuite suite : suites){
            Map<String, ISuiteResult> result = suite.getResults();
            reportWriter.println("<p>" + suite.getName());
            reportWriter.println("<ul>");
            for (String key : result.keySet()){
                ISuiteResult r = result.get(key);
                reportWriter.println("<li> " + r.getTestContext().getName() + "</li>");
                reportWriter.println("<li> " + r.getTestContext().getFailedTests().getAllResults() + "</li>");
                reportWriter.println("<li> " + r.getTestContext().getPassedTests().getAllResults() + "</li>");
                reportWriter.println("<br/>");

            }
            reportWriter.println("</ul></p>");
        }

        reportWriter.println("</body>");
        reportWriter.println("</html>");
        reportWriter.flush();

    }

    @Override
    public IReporterConfig getConfig() {
        return IReporter.super.getConfig();
    }
}
