package chapter6;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CreatingReports {
    public static void main(String[] args) {
        //Create an Extent Reports instance
        ExtentReports extent = new ExtentReports();
        //Create a report type
       // String reportPath = "src/test/resources/reports/myTestReport.html";
        String reportPath = "C:\\Users\\Kabelo Tlhape\\OneDrive - iLAB, LLC\\Pictures\\My Reports/myTestReport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        //Configure the report document
        reporter.config().setReportName("Kabelo's Report");
        reporter.config().setDocumentTitle("Testing Reports");
        extent.attachReporter(reporter);

        ExtentTest test1 = extent.createTest("Test 1");
        test1.log(Status.INFO,"Test Info")
                .log(Status.FAIL,"Test Failed")
                .log(Status.PASS,"Test Passed");

        ExtentTest test2 = extent.createTest("Test 2","This is just a description for test 2");
        test2.log(Status.PASS,"Test Passed")
                .log(Status.WARNING,"Test has warning")
                .log(Status.SKIP,"Test skipped");

        test2.addScreenCaptureFromPath("C:\\Users\\Kabelo Tlhape\\repos\\Selenium Projects\\July\\SeleniumTraining-July\\SeleniumTraining\\src\\test\\resources\\screenshots\\screenshot_[20240717_111741].png");
        extent.flush();

        try {
            Desktop.getDesktop().browse(new File(reportPath).toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
