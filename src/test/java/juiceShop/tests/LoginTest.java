package juiceShop.tests;

import juiceShop.pages.LoginPage;
import juiceShop.pages.LoginPageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest(){
        driver.get(BASE_URL + "login");
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.getLoginText(),loginPage.getStaticLoginText());
        loginPage.login("carina@yahoo.com","parolaeemkf");
    }
    @Test
    public void loginPageFactoryTest(){

        driver.get(BASE_URL + "login");
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        Assert.assertEquals(loginPage.getLoginText(),loginPage.getStaticLoginText());
        loginPage.login("carina@yahoo.com","sadsa243");
    }
}
