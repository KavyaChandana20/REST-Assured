package TestNG.jackson;

import TestNG.gson.serialization.Booking;
import TestNG.gson.serialization.BookingDates;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;


public class serialization
{
    @Test
    public void SerialznJackson() throws JsonProcessingException {


        Booking booking = new Booking();
        booking.setFirstname("James");
        booking.setLastname("Brown");
        booking.setTotalprice(500);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);


        ObjectMapper obj = new ObjectMapper();
        String jsonString = obj.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        System.out.println(jsonString);




    }
}
