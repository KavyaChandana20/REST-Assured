package CRUD_operations.FullCRUD_single;

import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class Prog1
{
    String token;
    Integer bookingId;
    RequestSpecification RS = RestAssured.given();
    ValidatableResponse VR;
    Response r;

    @BeforeTest
    public void getAToken(){
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        RS.baseUri("https://restful-booker.herokuapp.com/");
        RS.basePath("auth");
        RS.contentType(ContentType.JSON);
        RS.body(payload);

        r = RS.post();

        VR = r.then();
        VR.statusCode(200);

        // Extract the Token from this

        token = r.then().log().all().extract().path("token");
        Assert.assertNotNull(token); //token should not be null
    }
    @BeforeTest
    public void getBookingID(){

        String payload = "{\n" +
                "    \"firstname\" : \"Jimmy\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RS.baseUri("https://restful-booker.herokuapp.com");
        RS.basePath("/booking");
        RS.contentType(ContentType.JSON);
        RS.body(payload);

        r = RS.when().post();

        ValidatableResponse validatableResponse =  r.then();
        String responseString = r.asString();
        System.out.println(responseString);

        validatableResponse.statusCode(200);

        bookingId = r.then().log().all().extract().path("bookingid");
        String firstName = r.then().log().all().extract().path("booking.firstname");
        System.out.println(firstName);
        System.out.println(bookingId);
        Assert.assertNotNull(bookingId);  //BookingID should not be null

    }

    @Test
    public void testPUTRequestPositive(){
        // token and BookingID
        System.out.println(" - Test Case PUT Request ");

        String payload = "{\n" +
                "    \"firstname\" : \"Kavya\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";


        RS = RestAssured.given();
        RS.baseUri("https://restful-booker.herokuapp.com/");
        RS.basePath("booking/"+bookingId);
        RS.contentType(ContentType.JSON);
        RS.cookie("token",token);


        // Put Request
        RS.body(payload).log().all();

        r = RS.when().put();

        VR = r.then().log().all();
        VR.statusCode(200);

        String fullResponseJSONString = r.asString();
        System.out.println(fullResponseJSONString);

        // Verify all the keys and value pairs in the r
        // firstname, lastname, deposit, total, checkin


        /* 4 Ways You can verify the response -->
        1.Matchers, 2.Testng Assertions, 3.AssertJ  with Json Library, 4.AssertJ Matching
         */

        // 1. RA - Matchers
        VR.body("firstname", Matchers.equalTo("Kavya"));
        VR.body("lastname", Matchers.equalTo("Brown"));

        //  2. TestNG Asserts -
        //  Assert.assertEquals(firstNameResponse,"Pramod");
        String firstNameResponse = r.then().log().all().extract().path("firstname");
        Assert.assertEquals(firstNameResponse,"Kavya");

        // 3 TestNG Assertion with JSON Path Lib  --> Most used
        JsonPath jsonPath = new JsonPath(fullResponseJSONString);
        String firstNameJSONPathExtracted = jsonPath.getString("firstname");
        String lastNameJSONPathExtracted = jsonPath.getString("lastname");
        Integer totalpriceJSONPathExtracted = jsonPath.getInt("totalprice");
        String checkinDate = jsonPath.getString("bookingdates.checkin");


        Assert.assertEquals(firstNameJSONPathExtracted,"Kavya");
        Assert.assertEquals(lastNameJSONPathExtracted,"Brown");
        Assert.assertEquals(totalpriceJSONPathExtracted,111);
        Assert.assertEquals(checkinDate,"2018-01-01");
        Assert.assertNotNull(totalpriceJSONPathExtracted);

        // 4. AssertJ Matching

        assertThat(firstNameJSONPathExtracted)
                .isEqualTo("Kavya")
                .isNotBlank().isNotEmpty();

        assertThat(totalpriceJSONPathExtracted).isPositive().isNotZero();
        //Total price should not be zero & not negative

    }
}
