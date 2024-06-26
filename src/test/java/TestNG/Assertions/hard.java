package TestNG.Assertions;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class hard {

    @Description("TC Hard Assertion")
    @Test
    public void testCase()
    {
        //Hard Assertion
        Assert.assertEquals("pramod", "Pramod"); //if this line fails next SOP will not be executed
        System.out.println("End of the program");
    }


    @Test
    public void testCase1()
    {
        Assert.assertEquals(true, true);
    }

    @Test
    public void testCase2()
    {
        Assert.assertEquals(false, true);
    }

}
