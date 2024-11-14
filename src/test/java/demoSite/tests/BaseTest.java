package demoSite.tests;

import demoSite.pages.HomePage;
import frameworkUtils.TestUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static frameworkUtils.TestUtils.getConfigProperty;

public class BaseTest {

    protected WebDriver driver;
    protected static final String BASE_URL = TestUtils.getConfigProperty("demoSiteURL");
    public HomePage homePage;


    @BeforeMethod
    public void setup(){
        driver = TestUtils.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown(){
        try{
            driver.close();
        }
        catch (Exception e){
            driver.quit();
        }
    }
}
