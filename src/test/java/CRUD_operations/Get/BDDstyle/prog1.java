package CRUD_operations.Get.BDDstyle;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class prog1
{

    // Two Ways to create a RA Testcases
    // BDD Style - Given, When,Then
    // Non BDD Style - Class and Object --> Most used

    // Given()
    // URL
    // HEADER ?, Cookies
    // base url = https://api.zippopotam.us
    // basePath = /IN/560037
    // Auth - Basic, Digest, JWT, Bearer Token, OAuth 2.0 ? = No


    // When  ->
    // PaYLOAD - ? NO/yES - JSON. XML  -> String, Hashmap, Object class
    // GET Method



    // Then()
    // Response Validation
    //  Status Code
    //  Response Body
    //  Time, Headers ,Cookies

    @Test
    public void getRequestBDDStyle(){
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/560037")

                .when().log().all().get()

                .then()
                .log().all()        //prints all the logs
                .statusCode(200);


    }

    @Test
    public void getRequestBDDStyle2(){
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/560037")

                .when().log().all().get()

                .then()
                .log().all()  //prints all the logs
                .statusCode(200);


    }
}
