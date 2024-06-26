package TestNG;

import org.testng.annotations.*;

public class prog10
{
    @Parameters("browser")
    @Test(priority = 1)
    public void testDemo1(String value)
    {
        System.out.println("Browser is " + value);

        switch (value)
        {
            case "firefox":
                // Firefox Code
                System.out.println("Firefox starting and Running TC");
                break;
            case "chrome":
                // Chrome Code
                System.out.println("Chrome starting and Running TC");
                break;
            default:
                System.out.println("Edge starting and Running TC");
        }
    }
}
