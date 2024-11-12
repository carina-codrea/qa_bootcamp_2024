package juiceShop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import static frameworkUtils.TestUtils.waitElementToBeClickable;

public class BasePage {
    protected WebDriver driver;
    private static final By MODAL_OK_BTN = By.cssSelector("#mat-dialog-0 > app-welcome-banner > div > div:nth-child(3) > button.mat-focus-indicator.close-dialog.mat-raised-button.mat-button-base.mat-primary.ng-star-inserted");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public void clearInputField(WebElement inputField){
        inputField.clear();
    }

    public void awaitDismissModal(){
        waitElementToBeClickable(driver, Duration.ofSeconds(5), MODAL_OK_BTN).click();
    }
}
