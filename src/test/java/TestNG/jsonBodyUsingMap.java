package TestNG;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class jsonBodyUsingMap
{
    @Test
    public void testPOSTReq()
    {
        // "lastname" : "Brown", "firstname" : "Jim" - random Order
        Map<String,Object> lhm = new LinkedHashMap<>();
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        lhm.put("firstname",firstName);
        lhm.put("lastname",lastName);
        lhm.put("totalprice", faker.random().nextInt(1000));
        lhm.put("depositpaid", faker.random().nextBoolean());

        Map<String,Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkin","2018-01-01");
        bookingDatesMap.put("checkout","2018-01-05");

        lhm.put("bookingdates",bookingDatesMap);
        lhm.put("additionalneeds","Breakfast");

        System.out.println(lhm);


        RequestSpecification r = RestAssured
                .given();

        Response response;

        ValidatableResponse validatableResponse;

        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";
        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH);
        r.contentType(ContentType.JSON).log().all();
        r.body(lhm);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);


        validatableResponse = response.then();
        validatableResponse.statusCode(200);


    }
}
