package frameworkUtils;

public class Selectors {
    //main page
    public static final String PAGE_TEXT_SELECTOR = "body > app-root > div > mat-sidenav-container > mat-sidenav-content > app-search-result > div > div > div.heading.mat-elevation-z6 > div.ng-star-inserted";
    public static final String ACCOUNT_BUTTON_ID = "navbarAccount";
    public static final String LOGIN_BUTTON_ID = "navbarLoginButton";

    //login page
    public static final String MODAL_OK_BUTTON = "#mat-dialog-0 > app-welcome-banner > div > div:nth-child(3) > button.mat-focus-indicator.close-dialog.mat-raised-button.mat-button-base.mat-primary.ng-star-inserted";
    public static final String USERNAME_ID = "email";
    public static final String PASSWORD_ID = "password";
    public static final String SUBMIT_ID = "loginButton";
    public static final String REGISTER_URL = "#newCustomerLink > a";

    //register page
    public static final String REGISTER_HEADER = "body > app-root > div > mat-sidenav-container > mat-sidenav-content > app-register > div > mat-card > h1";
    public static final String REGISTER_EMAIL_ID = "emailControl";
    public static final String REGISTER_PASSWORD_ID = "passwordControl";
    public static final String REGISTER_CONFIRM_ID = "repeatPasswordControl";
    public static final String SECURITY_QUESTION_NAME = "securityQuestion";
    public static final String SECURITY_QUESTION_1 = "mat-option:first-of-type>span";
    public static final String SECURITY_ANSWER_ID = "securityAnswerControl";
    public static final String REGISTER_SUBMIT_BTN = "registerButton";
    public static final String BLOCKER_ELEMENT = "div.mat-simple-snack-bar-content";


}
