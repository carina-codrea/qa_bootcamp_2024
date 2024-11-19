package petStore.test;


import frameworkUtils.TestUtils;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static final String BASE_URL = TestUtils.getConfigProperty("petStoreURL");
    protected RequestSpecification httpRequest;

    @BeforeMethod
    public void setup(){
        RestAssured.baseURI = BASE_URL;
        httpRequest = RestAssured.given();

    }
}
