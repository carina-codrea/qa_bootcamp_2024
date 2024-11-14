package demoSite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
    @FindBy(css = "div.content h1")
    private WebElement welcomeHeader;
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getUsernameFromWelcomeHeader(){
        String welcome = welcomeHeader.getText();
        return welcome.split(",")[1].split("!")[0].trim();
    }

}
