package juiceShop.tests;

import frameworkUtils.TestUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static frameworkUtils.TestUtils.getConfigProperty;

public class BaseTest {

    protected WebDriver driver;
    protected static final String BASE_URL = getConfigProperty("baseURL");

    @BeforeMethod
    public void setup(){
        driver = TestUtils.getDriver();
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