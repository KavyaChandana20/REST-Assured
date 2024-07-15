package CRUD_operations.Put;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class PutRequestNonBDDstyle
{
    RequestSpecification r =RestAssured.given();
    Response res;
    ValidatableResponse vr;
    String token = "79c2802fcbea885";
    //get the token by running the url in Postman https://restful-booker.herokuapp.com/auth
    //token expires for every 15min

    String bookingid = "656"; // get this id from post req

    String BASE_URL = "https://restful-booker.herokuapp.com";
    String BASE_PATH = "/booking";

    @Test
    public void testPutREQUESTNonBDD(){
        String BASE_PATH_UPDATED = BASE_PATH+"/"+bookingid;
        System.out.println(BASE_PATH_UPDATED);

        // copy the output from Post req, paste here in payload & update the payload where ever we want.
        // format[", /, \n] will be copied automatically

        String payload = " {\n" +
                "        \"firstname\": \"John\",\n" +
                "        \"lastname\": \"Smith\",\n" +
                "        \"totalprice\": 111,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2018-01-01\",\n" +
                "            \"checkout\": \"2019-01-01\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Breakfast\"\n" +
                "    } ";

        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH_UPDATED);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(payload).log().all();

        res = r.when().log().all().put();

        vr = res.then().log().all();
        vr.statusCode(200);
        vr.body("firstname", Matchers.equalTo("John")); // verifying the updated name
        vr.body("lastname", Matchers.equalTo("Smith")); // verifying the updated name

    }
}
