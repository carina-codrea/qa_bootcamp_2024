package customReporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.time.Instant;

public class CustomTestListener extends TestListenerAdapter {
    ExtentReports extentReports = new ExtentReports();

    @Override
    public void onStart(ITestContext context){
        long unixTimeStamp = Instant.now().getEpochSecond();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/report" + unixTimeStamp + ".html");
        extentReports.attachReporter(sparkReporter);
    }

    @Override
    public void onTestStart(ITestResult result){
        String testMethodName = result.getMethod().getMethodName();
        String testDescription = result.getMethod().getDescription();
        System.out.println("Start test: " + testMethodName);
        ExtentTest myTest = extentReports.createTest(testMethodName);
        myTest.log(Status.INFO,"Test description: " + testDescription);

    }
    @Override
    public void onTestSuccess(ITestResult result){
        ExtentTest myTest = extentReports.createTest(result.getMethod().getMethodName());
        myTest.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result){
        ExtentTest myTest = extentReports.createTest(result.getMethod().getMethodName());
        myTest.fail("Test failed");
    }



    @Override
    public void onFinish(ITestContext context){
        extentReports.flush();
    }



}
