package demoSite.tests;

import frameworkUtils.TestUtils;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
public class CookieTest extends BaseTest{
    @Test
    public void cookieTest(){
        driver.get(BASE_URL + "#/");
        TestUtils.printCookies(driver);
        Cookie cookie = new Cookie("carinaCookie","cookieValue");
        driver.manage().addCookie(cookie);
        TestUtils.printCookies(driver);
        driver.manage().deleteCookie(cookie);
        TestUtils.printCookies(driver);
    }
}
