package juiceShop.pages;

import frameworkUtils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class RegistrationPage extends BasePage {
    private static final By REGISTER_HEADER = By.cssSelector("body > app-root > div > mat-sidenav-container > mat-sidenav-content > app-register > div > mat-card > h1");
    private static final By EMAIL_FIELD = By.id("emailControl");
    private static final By PASSWORD_FIELD = By.id("passwordControl");
    private static final By REPEAT_PASSWORD_FIELD = By.id("repeatPasswordControl");
    private static final By SECURITY_QUESTION_DROPDOWN = By.name("securityQuestion");
    private static final By SECURITY_ANSWER_FIELD = By.id("securityAnswerControl");
    private static final By REGISTER_BUTTON = By.id("registerButton");
    private static final By SECURITY_QUESTION_1 = By.cssSelector("mat-option:first-of-type>span");
    private static final By CHANGE_LANGUAGE_BLOCKER = By.cssSelector("div.mat-simple-snack-bar-content");
    private static final By OVERLAY_ELEMENT = By.id("cdk-overlay-0");
    private static final String REGISTER_HEADER_TEXT = "User Registration";

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        WebElement emailField = getElement(EMAIL_FIELD);
        clearInputField(emailField);
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordField = getElement(PASSWORD_FIELD);
        clearInputField(passwordField);
        passwordField.sendKeys(password);
    }

    public void enterRepeatPassword(String repeatPassword) {
        WebElement repeatPasswordField = getElement(REPEAT_PASSWORD_FIELD);
        clearInputField(repeatPasswordField);
        repeatPasswordField.sendKeys(repeatPassword);
    }

    public void clickOnSecurityQuestionDropdown() {
        getElement(SECURITY_QUESTION_DROPDOWN).click();
    }

    public void selectFirstSecurityQuestion() {
        getElement(SECURITY_QUESTION_1).click();
    }

    public void enterSecurityAnswer(String securityAnswer) {
        TestUtils.waitElementToBeInvisible(driver, Duration.ofSeconds(5), CHANGE_LANGUAGE_BLOCKER);
        WebElement securityAnswerField = getElement(SECURITY_ANSWER_FIELD);
        clearInputField(securityAnswerField);
        securityAnswerField.sendKeys(securityAnswer);
    }

    public void clickOnRegisterBtn() {
        TestUtils.waitElementToBeInvisible(driver, Duration.ofSeconds(5), OVERLAY_ELEMENT);
        getElement(REGISTER_BUTTON).click();
    }

    public String getRegisterHeaderText() {
        return getElement(REGISTER_HEADER).getText();
    }

    public String getRegisterStaticHeaderText() {
        return REGISTER_HEADER_TEXT;
    }

    public void register(String email, String password, String securityAnswer) {
        enterEmail(email);
        enterPassword(password);
        enterRepeatPassword(password);
        clickOnSecurityQuestionDropdown();
        selectFirstSecurityQuestion();
        enterSecurityAnswer(securityAnswer);
        clickOnRegisterBtn();
    }
}




