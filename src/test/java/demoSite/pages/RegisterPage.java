package demoSite.pages;

import demoSite.Gender;
import frameworkUtils.TestUtils;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class RegisterPage extends BasePage{
    @FindBy(id = "username")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "password2")
    private WebElement confirmPasswordField;
    @FindBy(id = "Mr")
    private WebElement mrRadioBtn;
    @FindBy(id = "Ms")
    private WebElement msRadioBtn;
    @FindBy(id = "input-first-name")
    private WebElement firstNameField;
    @FindBy(id = "input-last-name")
    private WebElement lastNameField;
    @FindBy(id = "input-email")
    private WebElement emailField;
    @FindBy(id = "input-dob")
    private WebElement dateOfBirthField;
    @FindBy(id = "input-nationality")
    private WebElement nationalitySelect;
    @FindBy(id = "terms")
    private WebElement termsCheckbox;
    @FindBy(css = "button.btn-primary")
    private WebElement submitBtn;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void registerWithAllFields(String username,
                                      String password,
                                      Gender gender,
                                      String firstName,
                                      String lastName,
                                      String email,
                                      String nationality,
                                      String dateOfBirth) {

        enterUsername(username);
        enterPassword(password);
        enterConfirmPassword(password);

        if (gender.equals(Gender.MALE)){
            clickMrRadioBtn();
        }
        else{
            clickMsRadioBtn();
        }

        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        selectDateOfBirth(dateOfBirth);
        selectNationality(nationality);
        checkTerms();
        submit();

    }

    public void registerWithRequiredFields(String username,String password) {
        enterUsername(username);
        enterPassword(password);
        enterConfirmPassword(password);
        checkTerms();
        submit();
    }

    public void enterUsername(String username){
        fillField(usernameField,username);
    }

    public void enterPassword(String password){
        fillField(passwordField,password);
    }
    public void enterConfirmPassword(String confirmPassword){
       fillField(confirmPasswordField,confirmPassword);
    }

    public void clickMrRadioBtn(){
        TestUtils.waitElementToBeClickable(driver,Duration.ofSeconds(5),mrRadioBtn).click();
        //mrRadioBtn.click();
    }

    public void clickMsRadioBtn(){
        TestUtils.waitElementToBeClickable(driver,Duration.ofSeconds(5),msRadioBtn).click();
        //msRadioBtn.click();
    }
    public void enterFirstName(String firstName){
        fillField(firstNameField,firstName);
    }
    public void enterLastName(String lastName){
        fillField(lastNameField,lastName);
    }

    public void enterEmail(String email){
        fillField(emailField,email);
    }

    public void selectDateOfBirth(String dateOfBirth){
       fillField(dateOfBirthField,dateOfBirth);
    }

    public void selectNationality(String nationality){
        Select select = new Select(nationalitySelect);
        select.selectByVisibleText(nationality);
    }

    public void checkTerms() {
        //scroll doesn't work,that s why I've tried with moveToElement
        TestUtils.moveToElement(driver,termsCheckbox);
        //TestUtils.scroll(driver,termsCheckbox);
        TestUtils.waitElementToBeClickable(driver,Duration.ofSeconds(5), By.id("terms")).click();
    }

    public void submit(){
        TestUtils.moveToElement(driver,submitBtn);
        submitBtn.click();
    }

    public String getUsernameValidationMessage() {
        return getInputValidationMessage(usernameField);
    }

    public String getPasswordValidationMessage() {
        return getInputValidationMessage(passwordField);
    }

    public String getConfirmPasswordValidationMessage() {
        return getInputValidationMessage(confirmPasswordField);
    }
    public String getFirstNameValidationMessage() {
        return getInputValidationMessage(firstNameField);
    }

    public String getLastNameValidationMessage() {
        return getInputValidationMessage(passwordField);
    }

}
