package TestNG;

import org.testng.annotations.Test;

public class prog8
{
    @Test
    public void serverStartedOk()
    {
        System.out.println("I will run first");
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void method1()
    {
        System.out.println("I will run second");
    }

}
