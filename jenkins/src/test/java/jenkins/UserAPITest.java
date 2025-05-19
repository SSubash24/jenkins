package jenkins;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserAPITest {

    @Test
    public void getUserDetails() {
        Response response = RestAssured
                .given()
                .baseUri("https://reqres.in")
                .when()
                .get("/api/users/2");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains("Janet"));
    }
}

