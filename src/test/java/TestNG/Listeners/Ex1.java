package TestNG.Listeners;
import org.testng.Assert;
import org.testng.annotations.*;


@Listeners(CustomListener.class)
public class Ex1
{
    @Test(groups = "sanity")
    public void test1()
    {
        System.out.println("test1");
        Assert.assertTrue(false);
    }

    @Test(groups = "sanity")
    public void test2()
    {
        System.out.println("test2");
        Assert.assertTrue(true);

    }

    @AfterSuite // AfterSuite will always  be executed at the last
    public void emailToQALead()
    {
        // Send the email
        System.out.println("After Suite Executing......\n");
        System.out.println("Sending Email\n");
    }
}
