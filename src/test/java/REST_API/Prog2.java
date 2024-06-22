package REST_API;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Prog2
{
    // @Description("TC#1 - Verify 261 GET Request 1")
    @Test
    public void getRequest()
    {
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get()
                .then().statusCode(201);
    }

    // @Description("TC#1 - Verify 261 GET Request 2")
    @Test
    public void getRequest2()
    {
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get()
                .then().statusCode(201);
    }
}
