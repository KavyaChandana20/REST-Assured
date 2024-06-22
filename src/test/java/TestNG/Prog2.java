package TestNG;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.*;

public class Prog2
{

        @Description("TC#1 - Verify GET Request 1")
        @Test
        public void getRequest()
        {
            System.out.println("TC1");
        }

        @Description("TC#1 - Verify GET Request 2")
        @Test(enabled = false) // will not exec as it is disabled
        public void getRequest2()
        {
            System.out.println("TC2");
        }

        @Description("TC#1 - Verify GET Request 3")
        @Test
        public void getRequest3()
        {
            System.out.println("TC3");
        }
    }
