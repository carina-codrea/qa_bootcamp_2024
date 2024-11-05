package frameworkUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class TestUtils {
    private static final String CONFIG_FILE = "config.properties";
    public static WebDriver getDriver(){
        WebDriver driver;

            String browser = getConfigProperty("browser").toLowerCase();

            switch (browser) {
                case "firefox" -> driver = new FirefoxDriver();
                case "edge" -> driver = new EdgeDriver();
                default -> driver = new ChromeDriver();

            }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return driver;


    }

    public static WebElement waitElementToBeClickable(WebDriver driver, Duration duration, By locator){
        WebDriverWait wait = new WebDriverWait(driver,duration);

        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver,Duration duration,By locator){
        WebDriverWait wait = new WebDriverWait(driver,duration);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitElementToBeInvisible(WebDriver driver,Duration duration,By locator){
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }



    public static String getConfigProperty(String propertyName){
        Properties properties = new Properties();
        String property = "";

        try{
            properties.load(new FileInputStream("config.properties"));
            property = properties.getProperty(propertyName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return property;
    }

    public static List<HashMap<String,Object>> getJsonDataToMap(String filePath){
        List<HashMap<String,Object>> data;
        try {
            String jsonFile = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//data//" + filePath));
            ObjectMapper objectMapper = new ObjectMapper();
            data = objectMapper.readValue(jsonFile, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return data;
    }

    public static String getValidationMessage(WebDriver driver,String inputId){
         WebElement validationElement = waitForElementToBeVisible(driver,Duration.ofSeconds(5),By.xpath("//div/input[@id='" +  inputId + "']/parent::div[1]/parent::div[1]/following-sibling::div"));
         return validationElement.getText();
    }



}
