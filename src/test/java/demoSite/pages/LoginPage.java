package demoSite.pages;

import frameworkUtils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class LoginPage extends BasePage{
    @FindBy(css = "a[href='/signup']")
    private WebElement registerLink;
    @FindBy(id = "user")
    private WebElement usernameField;
    @FindBy(id = "pass")
    private WebElement passwordField;
    @FindBy(id = "remember")
    private WebElement rememberMe;
    @FindBy(css = "button.btn-primary")
    private WebElement signInBtn;
    private final By validationMessage = By.cssSelector("small.form-error");

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickOnSignIn(){
        signInBtn.click();
    }
    public void clickOnRememberMe(){
        rememberMe.click();
    }
    public void login(String username,String password,boolean rememberMe){
        enterUsername(username);
        enterPassword(password);

        if (rememberMe){
            clickOnRememberMe();
        }

        clickOnSignIn();
    }
    public void goToRegister(){
        registerLink.click();
    }
    public String getLoginValidationMessage(){
      return TestUtils.waitElementToBeVisible(driver, Duration.ofSeconds(5),validationMessage).getText();
    }

    public String getUsernameValidationMessage(){
        return getInputValidationMessage(usernameField);
    }

    public String getPasswordValidationMessage(){
        return getInputValidationMessage(passwordField);
    }

}
