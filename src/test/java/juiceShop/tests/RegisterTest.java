package juiceShop.tests;

import juiceShop.pages.LoginPage;
import juiceShop.pages.MainPage;
import juiceShop.pages.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import static frameworkUtils.Selectors.*;
import static frameworkUtils.TestUtils.*;
import static frameworkUtils.TestUtils.getValidationMessage;


public class RegisterTest extends BaseTest {

    @Test(dataProvider = "loginRegisterProvider")
    public void loginRegister01Test(HashMap<String,String> inputData) throws InterruptedException {
        driver.get(BASE_URL + "login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.awaitDismissModal();
        loginPage.newUser();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        Assert.assertEquals(registrationPage.getRegisterHeaderText(),registrationPage.getRegisterStaticHeaderText());
        registrationPage.register(inputData.get("email"),inputData.get("password"),inputData.get("securityAnswer"));


    }


    // homework old version 04.11.2024
    @Test(dataProvider = "registerNegativeProvider" )
    public void registerE2ENegative01Test(HashMap<String,String> inputData) {

        driver.get(BASE_URL);

        waitElementToBeClickable(driver, Duration.ofSeconds(5), By.cssSelector(MODAL_OK_BUTTON)).click();

        driver.findElement(By.id(ACCOUNT_BUTTON_ID)).click();
        driver.findElement(By.id(LOGIN_BUTTON_ID)).click();
        driver.findElement(By.cssSelector(REGISTER_URL)).click();

        if (inputData.containsKey("email")){
            WebElement emailElement = driver.findElement(By.id(REGISTER_EMAIL_ID));
            emailElement.clear();
            emailElement.sendKeys(inputData.get("email"));
        }

        if (inputData.containsKey("password")) {
            WebElement passwordElement = driver.findElement(By.id(REGISTER_PASSWORD_ID));
            passwordElement.clear();
            passwordElement.sendKeys(inputData.get("password"));
        }

        if (inputData.containsKey("repeatPassword")) {
            WebElement confirmPasswordElement = driver.findElement(By.id(REGISTER_CONFIRM_ID));
            confirmPasswordElement.clear();
            confirmPasswordElement.sendKeys(inputData.get("repeatPassword"));
        }

        if (inputData.containsKey("securityAnswer")){

            waitElementToBeInvisible(driver,Duration.ofSeconds(5),By.cssSelector(BLOCKER_ELEMENT));
            driver.findElement(By.name(SECURITY_QUESTION_NAME)).click();
            driver.findElement(By.cssSelector(SECURITY_QUESTION_1)).click();

            WebElement securityAnswerElement = driver.findElement(By.id(SECURITY_ANSWER_ID));
            securityAnswerElement.clear();
            securityAnswerElement.sendKeys(inputData.get("securityAnswer"));

        }

        //click on neutral element to trigger validation
        driver.findElement(By.tagName("h1")).click();

        String testName = inputData.get("testName");
        String expectedValidationMessage = inputData.get("validationMessage");
        System.out.println("Validation message:" + expectedValidationMessage);


        switch (testName){
            case "invalidEmailNoAtSymbol":
            case "invalidEmailNoDomain":
            case "invalidEmailNoDomainSuffix":
            case "invalidEmailWithSpaces":
            case "invalidEmailNoPrefix":
            case "invalidEmailEmpty":
                Assert.assertEquals(getValidationMessage(driver,REGISTER_EMAIL_ID),expectedValidationMessage);
                break;
            case "shortPassword":
            case "longPassword":
            case "emptyPassword":
                Assert.assertEquals(getValidationMessage(driver,REGISTER_PASSWORD_ID),expectedValidationMessage);
                break;
            case "noMatchingPasswords":
            case "emptyRepeatPassword":
                Assert.assertEquals(getValidationMessage(driver,REGISTER_CONFIRM_ID),expectedValidationMessage);
                break;
            case "emptySecurityAnswer" : Assert.assertEquals(getValidationMessage(driver,SECURITY_ANSWER_ID),expectedValidationMessage);

        }

    }

    // homework new version 05.11.2024
    @Test(dataProvider = "registerNegativeProvider")
    public void registerE2ENegative02Test(HashMap<String,String> inputData){
        driver.get(BASE_URL);

        MainPage mainPage = new MainPage(driver);
        mainPage.awaitDismissModal();
        mainPage.clickOnAccountBtn();
        mainPage.clickOnLoginBtn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.newUser();

        RegistrationPage registrationPage = new RegistrationPage(driver);

        if (inputData.containsKey("email")){
            registrationPage.enterEmail(inputData.get("email"));
        }

        if (inputData.containsKey("password")) {
            registrationPage.enterPassword(inputData.get("password"));
        }

        if (inputData.containsKey("repeatPassword")) {
            registrationPage.enterRepeatPassword(inputData.get("repeatPassword"));
        }

        if (inputData.containsKey("securityAnswer")){
            registrationPage.clickOnSecurityQuestionDropdown();
            registrationPage.selectFirstSecurityQuestion();
            registrationPage.enterSecurityAnswer(inputData.get("securityQuestion"));

        }

        //click on neutral element to trigger validation
        driver.findElement(By.tagName("h1")).click();

        String testName = inputData.get("testName");
        String expectedValidationMessage = inputData.get("validationMessage");
        System.out.println("Validation message:" + expectedValidationMessage);

        switch (testName){
            case "invalidEmailNoAtSymbol":
            case "invalidEmailNoDomain":
            case "invalidEmailNoDomainSuffix":
            case "invalidEmailWithSpaces":
            case "invalidEmailNoPrefix":
            case "invalidEmailEmpty":
                Assert.assertEquals(getValidationMessage(driver,REGISTER_EMAIL_ID),expectedValidationMessage);
                break;
            case "shortPassword":
            case "longPassword":
            case "emptyPassword":
                Assert.assertEquals(getValidationMessage(driver,REGISTER_PASSWORD_ID),expectedValidationMessage);
                break;
            case "noMatchingPasswords":
            case "emptyRepeatPassword":
                Assert.assertEquals(getValidationMessage(driver,REGISTER_CONFIRM_ID),expectedValidationMessage);
                break;
            case "emptySecurityAnswer":
                Assert.assertEquals(getValidationMessage(driver,SECURITY_ANSWER_ID),expectedValidationMessage);
        }

    }

    @DataProvider
    public Object[][] loginRegisterProvider(){
        List<HashMap<String,Object>> hashMapList = getJsonDataToMap("juiceShop/loginRegister.json");
        Object[][] data = new Object[hashMapList.size()][];

        for (int i = 0; i <hashMapList.size() ; i++) {
            data[i] = new Object[] {hashMapList.get(i)};

        }
        return data;

    }

    @DataProvider
    public Object[][] registerNegativeProvider(){

        List<HashMap<String,Object>> hashMapList = getJsonDataToMap("juiceShop/registerNegativeE2E.json");
        Object[][] data = new Object[hashMapList.size()][];

        for (int i = 0; i <hashMapList.size() ; i++) {
            data[i] = new Object[] {hashMapList.get(i)};

        }
        return data;
    }
}
