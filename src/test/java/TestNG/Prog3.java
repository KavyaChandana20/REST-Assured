package TestNG;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class Prog3
{

        @Description("TC#1 - Verify GET Request 1")
        @Test
        public void getRequest()
        {
            System.out.println("TC1");
        }

        @Description("TC#2 - Verify GET Request 2")
        @Test // will not exec as it is disabled
        public void getRequest2()
        {
            System.out.println("TC2");
        }

        @Description("TC#3 - Verify GET Request 3")
        @Test
        public void getRequest3()
        {
            System.out.println("TC3");
        }
    }
