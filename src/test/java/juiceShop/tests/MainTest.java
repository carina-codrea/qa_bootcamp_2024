package juiceShop.tests;

import juiceShop.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BaseTest{

    @Test
    public void mainPage()  {
        driver.get(BASE_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.awaitDismissModal();
        Assert.assertEquals(mainPage.getAllProductText(),mainPage.getStaticAllProductsText());
    }



}
