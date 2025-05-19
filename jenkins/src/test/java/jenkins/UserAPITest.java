package jenkins;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserAPITest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    public void getUserDetails() {
        Response response = RestAssured
                .given()
                .header("x-api-key", "reqres-free-v1")  // Add API key header here
                .when()
                .get("/api/users/2");

        // Print response for visibility
        response.prettyPrint();

        // Assert status code
        Assert.assertEquals(response.getStatusCode(), 200);

        // Assert specific field
        String firstName = response.jsonPath().getString("data.first_name");
        Assert.assertEquals(firstName, "Janet");
    }
}
