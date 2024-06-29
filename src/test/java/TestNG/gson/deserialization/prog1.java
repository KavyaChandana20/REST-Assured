package TestNG.gson.deserialization;

import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;

public class prog1
{
    //Converting a Json string to obj is De-serialization.

    @Test
    public void DeSerializationTest(){

        String jsonString = "{\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        Gson gson = new Gson();
        Booking booking = gson.fromJson(jsonString,Booking.class);
        System.out.println(booking.toString());
        System.out.println(booking.getFirstname());

        Assert.assertEquals(booking.getFirstname(),"Jim");
        // Assert.assertEquals(booking.getFirstname(),"Kavya"); // fails as expected value is Jim




    }
}
