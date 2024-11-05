package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

public class MainTest extends BaseTest{

    @Test
    public void mainPage(){
        driver.get(BASE_URL);
        MainPage mainPage = new MainPage(driver);
        Assert.assertEquals(mainPage.getAllProductText(),mainPage.getStaticAllProductsText());
    }
}
