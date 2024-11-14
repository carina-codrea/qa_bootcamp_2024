package demoSite.tests;

import demoSite.pages.LoginPage;
import frameworkUtils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.HashMap;
import java.util.List;

public class LoginTest extends BaseTest {
    public LoginPage loginPage;

    @Test(dataProvider = "validLoginData")
    public void loginWithValidCredentialsTest(HashMap<String,String> inputData) {
        String username = inputData.get("username");

        loginPage.login(username,inputData.get("password"),false);

        Assert.assertEquals(homePage.getUsernameFromWelcomeHeader(),username);
    }

    @Test(dataProvider = "invalidLoginData")
    public void loginWithInvalidCredentialsTest(HashMap<String,String> inputData){
        loginPage.login(inputData.get("username"),inputData.get("password"),false);

        Assert.assertEquals(loginPage.getLoginValidationMessage(),"Invalid username or password!");
    }
    @Test
    public void loginWithEmptyFieldsTest(){
        loginPage.login("","",false);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getUsernameValidationMessage(),"Please enter your username");
        softAssert.assertEquals(loginPage.getPasswordValidationMessage(),"Please enter your password");
        softAssert.assertAll();
    }

//    @Test(dataProvider = "validLoginData")
//    public void loginWithRememberMeTest(HashMap<String,String> inputData){
//        String username = inputData.get("username");
//
//        loginPage.login(username,inputData.get("password"),true);
//        Cookie cookie = driver.manage().getCookieNamed("remember_token");
//        System.out.println(cookie.getValue());
////        driver.close();
////
////        setup();
////        driver.get(BASE_URL);
////        Assert.assertEquals(homePage.getUsernameFromWelcomeHeader(),username);
//
//
//
//    }

    @DataProvider
    public Object[][] validLoginData(){
     List<HashMap<String,Object>> loginData = TestUtils.getJsonDataToMap("/demoSite/loginValidCredentials.json");
     return TestUtils.convertListToDataProvider(loginData);
    }

    @DataProvider
    public Object[][] invalidLoginData(){
        List<HashMap<String,Object>> loginData = TestUtils.getJsonDataToMap("/demoSite/loginInvalidCredentials.json");
        return TestUtils.convertListToDataProvider(loginData);
    }

    @BeforeMethod
    public void setup(){
        super.setup();
        homePage.goToLogin();
        loginPage = new LoginPage(driver);
    }


}
