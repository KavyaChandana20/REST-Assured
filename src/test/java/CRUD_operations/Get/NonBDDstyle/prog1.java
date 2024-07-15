package CRUD_operations.Get.NonBDDstyle;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class prog1
{
    // Two Ways to create a RA Testcases
    // BDD Style - Given, When,Then
    // Non BDD Style - Class and Object --> Most used

    RequestSpecification rs = RestAssured.given();

    @Test
    public void getRequestNonBDDStyle() {
        // given
        rs.baseUri("https://api.zippopotam.us");
        rs.basePath("/IN/560037");
        rs.when().log().all().get();
        rs.then().log().all().statusCode(200);

    }

    @Test
    public void getRequestNonBDDStyle2() {
        // given
        rs.baseUri("https://api.zippopotam.us");
        rs.basePath("/IN/560037");
        rs.when().log().all().get();
        rs.then().log().all().statusCode(200);


    }
}
