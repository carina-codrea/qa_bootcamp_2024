package demoSite.tests;

import demoSite.Gender;
import demoSite.pages.LoginPage;
import demoSite.pages.RegisterPage;
import frameworkUtils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;

public class RegisterTest extends BaseTest {
    public RegisterPage registerPage;

    @Test(dataProvider = "registerWithAllFieldsData")
    public void registerWithAllFieldsTest(HashMap<String,String> inputData) {
        String username = inputData.get("username");

        registerPage.registerWithAllFields(
                username,
                inputData.get("password"),
                Gender.valueOf(inputData.get("gender")),
                inputData.get("firstName"),
                inputData.get("lastName"),
                inputData.get("email"),
                inputData.get("nationality"),
                inputData.get("dateOfBirth"));

        Assert.assertEquals(homePage.getUsernameFromWelcomeHeader(),username);
    }

    @Test(dataProvider = "registerWithRequiredFieldsData")
    public void registerWithRequiredFieldsTest(HashMap<String,String> inputData) {
        String username = inputData.get("username");
        registerPage.registerWithRequiredFields(username,inputData.get("password"));

        // terms checkbox is clicked but somehow not selected :-??

        Assert.assertEquals(homePage.getUsernameFromWelcomeHeader(),username);

    }

    @Test(dataProvider = "registerNegativeData")
    public void registerNegativeTest(HashMap<String,String> inputData){
        String actualValidationMessage = "";

        if (inputData.containsKey("username")){
            registerPage.enterUsername(inputData.get("username"));
            actualValidationMessage = registerPage.getUsernameValidationMessage();

        }
        if (inputData.containsKey("password")){
            registerPage.enterPassword(inputData.get("password"));
            actualValidationMessage = registerPage.getPasswordValidationMessage();
        }
        if (inputData.containsKey("confirmPassword")){
            registerPage.enterConfirmPassword(inputData.get("confirmPassword"));
            actualValidationMessage = registerPage.getConfirmPasswordValidationMessage();
        }
        if (inputData.containsKey("firstName")){
            registerPage.enterFirstName(inputData.get("firstName"));
            actualValidationMessage = registerPage.getFirstNameValidationMessage();
        }
        if (inputData.containsKey("lastName")){
            registerPage.enterLastName(inputData.get("lastName"));
            actualValidationMessage = registerPage.getLastNameValidationMessage();
        }


        String testCase = inputData.get("testCase");
        String expectedValidationMessage = inputData.get("validationMessage");

        Assert.assertEquals(actualValidationMessage,expectedValidationMessage,testCase + " failed.");

    }


    @DataProvider
    public Object[][] registerWithAllFieldsData() {
        HashMap<String,Object> allFieldsData = (HashMap<String, Object>) TestUtils.getJsonDataToMap("demoSite/register.json","registerWithAllFields");
        return new Object[][] {{allFieldsData}};

    }
    @DataProvider
    public Object[] registerWithRequiredFieldsData() {
        HashMap<String, Object> requiredFieldsData = (HashMap<String,Object>) TestUtils.getJsonDataToMap("demoSite/register.json", "registerWithRequiredFields");
        return new Object[][] { { requiredFieldsData } };
    }
    @DataProvider
    public Object[][] registerNegativeData() {
        List<HashMap<String, Object>> negativeTestsData = (List<HashMap<String,Object>>) TestUtils.getJsonDataToMap("demoSite/register.json", "negativeTests");

        return TestUtils.convertListToDataProvider(negativeTestsData);
    }

    @BeforeMethod
    public void setup(){
        super.setup();
        homePage.goToLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToRegister();
        registerPage = new RegisterPage(driver);
    }

    }



