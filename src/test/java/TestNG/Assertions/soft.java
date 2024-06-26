package TestNG.Assertions;

import io.qameta.allure.Description;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class soft
{
    @Description("TC soft Assertion")
    @Test
    public void testCase()
    {

        // Assertion ->  Expect Result = Actual Result
        // 200 == 200

        // Soft Assertions
        SoftAssert s = new SoftAssert();
        s.assertEquals("kavya", "Kavya", "Not Equal");
        // even if this line fails next SOP will be executed, until "assertAll"
        s.assertEquals("abc", "abd", "Not Equal");
        s.assertEquals("jeu", "jeu", "Equal");
        System.out.println("End 1");
        System.out.println("End 2");
        s.assertAll();
    }
}
