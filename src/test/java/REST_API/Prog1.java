package REST_API;

import io.restassured.RestAssured;

public class Prog1
{
    public static void main(String[] args)
    {
        //given, when, then
        // https://restful-booker.herokuapp.com/ping --> entire URL

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")

                .when().get()

                .then().statusCode(201);
    }
}
