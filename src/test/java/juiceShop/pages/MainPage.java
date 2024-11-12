package juiceShop.pages;

import juiceShop.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    @FindBy(css = "body > app-root > div > mat-sidenav-container > mat-sidenav-content > app-search-result > div > div > div.heading.mat-elevation-z6 > div.ng-star-inserted")
    private WebElement allProducts;
    @FindBy(id = "navbarAccount")
    private WebElement accountBtn;
    @FindBy(id = "navbarLoginButton")
    private WebElement loginBtn;
    private static final String ALL_PRODUCTS_TEXT = "All Products";
    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


    public void clickOnAccountBtn(){
        accountBtn.click();
    }

    public void clickOnLoginBtn(){
        loginBtn.click();
    }

    public String getAllProductText(){
        return allProducts.getText();
    }

    public String getStaticAllProductsText(){
        return ALL_PRODUCTS_TEXT;
    }
}
