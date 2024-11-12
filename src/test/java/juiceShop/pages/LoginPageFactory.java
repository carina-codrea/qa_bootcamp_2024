package juiceShop.pages;

import juiceShop.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import static frameworkUtils.Selectors.MODAL_OK_BUTTON;
import static frameworkUtils.TestUtils.waitElementToBeClickable;

public class LoginPageFactory extends BasePage {

    private static final String loginTextValue = "Login";

    @FindBy(css = "body > app-root > div > mat-sidenav-container > mat-sidenav-content > app-login > div > mat-card > h1")
    private WebElement loginHeader;
    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "loginButton")
    private WebElement loginBtn;
    @FindBy(css ="#newCustomerLink > a" )
    private WebElement registerLink;
    @FindBy(css = "mat-dialog-0 > app-welcome-banner > div > div:nth-child(3) > button.mat-focus-indicator.close-dialog.mat-raised-button.mat-button-base.mat-primary.ng-star-inserted")
    private WebElement modalDismissBtn;

    public LoginPageFactory(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void login(String email,String password){
        dismissModal();

        emailField.clear();
        emailField.sendKeys(email);

        passwordField.clear();
        passwordField.sendKeys(password);

        loginBtn.click();

    }

    public void dismissModal(){
        waitElementToBeClickable(driver,Duration.ofSeconds(5), By.cssSelector(MODAL_OK_BUTTON)).click();
    }

    public String getLoginText(){
        return loginHeader.getText();
    }

    public String getStaticLoginText(){
        return loginTextValue;
    }

}
