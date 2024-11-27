package petStore.test;

import io.restassured.http.Method;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import petStore.models.Order;
import petStore.models.Status;
import petStore.utils.Utils;

public class StoreTest extends BaseTest {
    private int generatedOrderId;

    @Test
    public void placeOrderTest(){
        Order order = new Order(Utils.generateRandomNumber(30000),
                30000567,
                2,
                Utils.getCurrentDateTimeInFormat(),
                Status.PLACED.getStatus(),
                true);

        httpRequest.contentType("application/json");
        httpRequest.body(Utils.convertObjectToJson(order));
        Response response = httpRequest.request(Method.POST,"/store/order");
        Assert.assertEquals(response.statusCode(), 200);
        generatedOrderId = response.jsonPath().getInt("id");

    }

    @Test(dependsOnMethods = "placeOrderTest")
    public void findOrderByIdTest(){
        httpRequest.pathParam("orderId",generatedOrderId);
        Response response = httpRequest.request(Method.GET,"/store/order/{orderId}");

        Order order = Utils.convertJsonToObject(response.getBody().asString(),Order.class);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(order.getId(),generatedOrderId);

    }
}
