package demoSite.pages;

import com.beust.ah.A;
import frameworkUtils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;

    @FindBy(css = "a[href='/alerts']")
    private WebElement alerts;
    @FindBy(css = "a[href='/cookie']")
    private WebElement cookie;
    @FindBy(css = "a[href='/hover']")
    private WebElement hover;
    @FindBy(css = "a[href='/signin']")
    private WebElement signIn;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void goToLogin(){
        signIn.click();
    }

    public void goToAlerts(){
        alerts.click();
    }
    public void goToHover(){
        hover.click();
    }

    public String getInputValidationMessage(WebElement input){
       TestUtils.contextClick(driver);
      return TestUtils.waitElementToBeVisible(driver,Duration.ofSeconds(5), input.findElement(By.xpath("./parent::div/following-sibling::small[@class='form-error']"))).getText();


    }

    public void fillField(WebElement element,String value){
        element.clear();
        element.sendKeys(value);
    }


}
