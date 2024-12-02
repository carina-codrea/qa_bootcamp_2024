package petStore.test;

import com.google.gson.Gson;
import io.restassured.http.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import petStore.models.Category;
import petStore.models.Pet;
import petStore.models.Tag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import static org.hamcrest.MatcherAssert.assertThat;


public class PetTest extends BaseTest {

    @DataProvider(name = "FindPetById")
    public Iterator<Object[]> findPetDp () {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] {"99991", "404", ""});
        dp.add(new String[] {"10", "200", "doggie"});
        return dp.iterator();
    }
    @Test(dataProvider = "FindPetById",dependsOnMethods = "createPet2")
    public void findPetById(String petId, String responseCode, String name) {
        Response response = httpRequest.request(Method.GET, "/pet/" + petId);
        Assert.assertEquals(response.getStatusCode(), Integer.parseInt(responseCode));
        assertThat(response.getStatusLine(), Matchers.containsStringIgnoringCase("HTTP/1.1"));
        Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
        Assert.assertEquals(response.getHeader("Access-Control-Allow-Methods"), "GET, POST, DELETE, PUT");
        Assert.assertEquals(response.getDetailedCookies().asList().size(), 0);
//        System.out.println(response.getBody().asString());
        JsonPath jsonPathEvaluator = response.jsonPath();
        if(response.getStatusCode() == 404) {
            Assert.assertEquals(jsonPathEvaluator.getString("message"), "Pet not found");
        }
        if (response.getStatusCode() == 200) {
            Assert.assertEquals(jsonPathEvaluator.getString("name"), name);
//            Assert.assertEquals(jsonPathEvaluator.getString("category.name"), "string");
        }
    }
    @Test
    public void createPet() {
        Category cat = new Category(231, "myName");
        Tag tag = new Tag(567, "tagName");
        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(tag);
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("http://myurl.com");
        Pet pet = new Pet(699, cat, "linda", photoUrls, tags, "available");
        // Serializing Object to JSON String
        Gson gson = new Gson();
        String jsonOutput = gson.toJson(pet);
        System.out.println(jsonOutput);
        httpRequest.body(jsonOutput);
        httpRequest.contentType("application/json");
        Response response = httpRequest.request(Method.POST, "/pet");
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        // Deserializing Json string to Object
        Pet myPet = gson.fromJson(jsonOutput, Pet.class);
        System.out.println(myPet.getName());
    }
    @Test
    public void createPet2() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("id", "100");
        requestParams.put("name", "doggie");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toString());
        Response response = httpRequest.request(Method.POST, "/pet");
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
    }


}
