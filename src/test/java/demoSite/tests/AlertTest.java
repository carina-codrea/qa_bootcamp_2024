package demoSite.tests;

import frameworkUtils.TestUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest extends BaseTest {

    @Test
    public void openAlertConfirmTest() {
        homePage.goToAlerts();
        TestUtils.waitElementToBeVisible(driver,Duration.ofSeconds(5),By.id("alert-trigger")).click();
        driver.switchTo().alert().accept();

    }
    @Test
    public void openConfirmationDialogTest() {
        homePage.goToAlerts();
        TestUtils.waitElementToBeVisible(driver, Duration.ofSeconds(5),By.id("confirm-trigger")).click();
        driver.switchTo().alert().dismiss();

    }

    @Test
    public void openPromptDialogTest() throws InterruptedException {
        homePage.goToAlerts();
        TestUtils.waitElementToBeVisible(driver,Duration.ofSeconds(5),By.id("prompt-trigger")).click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Carina");
        Thread.sleep(3000);
        alert.accept();

    }
    @Test
    public void hoverTest() {
        driver.get(BASE_URL);
        driver.findElement(By.cssSelector("a[href='/hover']")).click();
        WebElement hoverBtn = TestUtils.waitElementToBeVisible(driver,Duration.ofSeconds(5),By.cssSelector("#svelte > div.container-fluid > div.main.row > div.content > div > button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverBtn);
        actions.perform();

    }

}
