package demoSite.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    @Test
    public void openAlertConfirmTest() {
        driver.get(BASE_URL);
        driver.findElement(By.cssSelector("#svelte > div.container-fluid > div.main.row > div.sidebar > a:nth-child(1)")).click();
        driver.findElement(By.id("alert-trigger")).click();

        driver.switchTo().alert().accept();

    }
    @Test
    public void openConfirmationDialogTest() {
        driver.get(BASE_URL);
        driver.findElement(By.cssSelector("#svelte > div.container-fluid > div.main.row > div.sidebar > a:nth-child(1)")).click();
        driver.findElement(By.id("confirm-trigger")).click();

        driver.switchTo().alert().accept();


    }

    @Test
    public void openPromptDialogTest() throws InterruptedException {
        driver.get(BASE_URL);
        driver.findElement(By.cssSelector("#svelte > div.container-fluid > div.main.row > div.sidebar > a:nth-child(1)")).click();
        driver.findElement(By.id("prompt-trigger")).click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Carina");
        Thread.sleep(3000);
        alert.accept();

    }
    @Test
    public void hoverTest() {
        driver.get(BASE_URL);
        driver.findElement(By.cssSelector("#svelte > div.container-fluid > div.main.row > div.sidebar > a:nth-child(3)")).click();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector("#svelte > div.container-fluid > div.main.row > div.content > div > button")));
        actions.perform();

    }

}
