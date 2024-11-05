package pages;

import frameworkUtils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static frameworkUtils.Selectors.MODAL_OK_BUTTON;
import static frameworkUtils.TestUtils.waitElementToBeClickable;

public class LoginPage extends BasePage {

    private static final String LOGIN_TEXT_SELECTOR = "body > app-root > div > mat-sidenav-container > mat-sidenav-content > app-login > div > mat-card > h1";
    private static final String EMAIL_SELECTOR = "email";
    private static final String PASSWORD_SELECTOR = "password";
    private static final String LOGIN_BTN_SELECTOR = "loginButton";
    private static final String REGISTER_LINK_SELECTOR = "#newCustomerLink > a";
    private static final String MODAL_OK_BTN_SELECTOR = "mat-dialog-0 > app-welcome-banner > div > div:nth-child(3) > button.mat-focus-indicator.close-dialog.mat-raised-button.mat-button-base.mat-primary.ng-star-inserted";
    private static final String LOGIN_TEXT_VALUE = "Login";

    public LoginPage(WebDriver driver){
        super(driver);

    }

    public void login(String email,String password){

        awaitDismissModal();

        WebElement emailField = driver.findElement(By.id(EMAIL_SELECTOR));
        emailField.clear();
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.id(PASSWORD_SELECTOR));
        passwordField.clear();
        passwordField.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.id(LOGIN_BTN_SELECTOR));
        loginBtn.click();
    }


    public void newUser(){
        WebElement newUserLink = driver.findElement(By.cssSelector(REGISTER_LINK_SELECTOR));
        newUserLink.click();
    }

    public String getLoginText(){
       return driver.findElement(By.cssSelector(LOGIN_TEXT_SELECTOR)).getText();
    }

    public String getStaticLoginText(){
        return LOGIN_TEXT_VALUE;
    }
}
