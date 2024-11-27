package frameworkUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class TestUtils {
    private static final String CONFIG_FILE = "config.properties";
    public static WebDriver getDriver(){
        WebDriver driver;

        String browser = getConfigProperty("browser").toLowerCase();

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("127.0.0.1:6969");

        switch (browser) {
            case "firefox" :
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                FirefoxProfile firefoxProfile = new FirefoxProfile();
                if (Boolean.parseBoolean(getConfigProperty("headless"))){
                    firefoxOptions.addArguments("--headless");

                }
                firefoxOptions.setProfile(firefoxProfile);
                firefoxProfile.setPreference("browser.download.dir",".");

                if (Boolean.parseBoolean(getConfigProperty("maximized"))){
                    firefoxOptions.addArguments("--start-maximized");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (Boolean.parseBoolean(getConfigProperty("headless"))){
                    edgeOptions.addArguments("--headless");

                }
                if (Boolean.parseBoolean(getConfigProperty("maximized"))){
                    edgeOptions.addArguments("--start-maximized");
                }

                driver = new EdgeDriver(edgeOptions);
                break;


            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                //chromeOptions.setCapability("proxy",proxy);

                if (Boolean.parseBoolean(getConfigProperty("headless"))){
                    chromeOptions.addArguments("--headless");

                }
                if (Boolean.parseBoolean(getConfigProperty("maximized"))){
                    chromeOptions.addArguments("--start-maximized");
                }

//                  Map<String,Object> prefs = new HashMap<>();
//                  prefs.put("prefs",prefs);

                driver = new ChromeDriver(chromeOptions);
        }


        return driver;


    }

    public static WebElement waitElementToBeClickable(WebDriver driver, Duration duration, By locator){
        WebDriverWait wait = new WebDriverWait(driver,duration);

        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static WebElement waitElementToBeClickable(WebDriver driver, Duration duration, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,duration);

        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitElementToBeVisible(WebDriver driver, Duration duration, By locator){
        WebDriverWait wait = new WebDriverWait(driver,duration);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitElementToBeVisible(WebDriver driver, Duration duration, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,duration);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static void waitElementToBeInvisible(WebDriver driver,Duration duration,By locator){
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitElementToBePresent(WebDriver driver,Duration duration,WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,duration);

    }

    public static void jsClick(WebDriver driver,WebElement element){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();",element);
    }



    public static String getConfigProperty(String propertyName){
        Properties properties = new Properties();
        String property = "";

        try{
            properties.load(new FileInputStream(CONFIG_FILE));
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

    public static Object getJsonDataToMap(String filePath, String key) {
        Map<String, Object> data;
        try {
            String jsonFile = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//data//" + filePath));
            ObjectMapper objectMapper = new ObjectMapper();
            data = objectMapper.readValue(jsonFile, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return data.get(key);
    }


    public static Object[][] convertListToDataProvider(List<HashMap<String, Object>> hashMapList) {
        Object[][] data = new Object[hashMapList.size()][1];

        for (int i = 0; i < hashMapList.size(); i++) {
            data[i][0] = hashMapList.get(i);
        }
        return data;
    }



    public static String getValidationMessage(WebDriver driver,String inputId){
        WebElement validationElement = waitElementToBeVisible(driver,Duration.ofSeconds(5),By.xpath("//div/input[@id='" +  inputId + "']/parent::div[1]/parent::div[1]/following-sibling::div"));
        return validationElement.getText();
    }

    public static void scroll(WebDriver driver,WebElement element){
        JavascriptExecutor jsExe = (JavascriptExecutor) driver;
        jsExe.executeScript("arguments[0].scrollIntoView(false);",element);
    }

    public static void scroll(WebDriver driver,int x, int y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(" + x + "," + y + ");");
    }

    public static void moveToElement(WebDriver driver,WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void printCookies(WebDriver driver){
        Set<Cookie> cookies =  driver.manage().getCookies();

        for (Cookie cookie : cookies){
            System.out.println(cookie.toJson());
        }
    }

    public static void contextClick(WebDriver driver){
        driver.findElement(By.tagName("body")).click();
    }



}
