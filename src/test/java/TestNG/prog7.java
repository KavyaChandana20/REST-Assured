package TestNG;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class prog7
{

    @Issue("Bug-123")
    @AllureId("TC#1")
    @Severity(SeverityLevel.NORMAL)
    @Description("Sanity Testcase")

    @Test(groups = {"A"},priority = 1)
    public void SanityRun()
    {
        System.out.println("Sanity");
        System.out.println("QA");
    }

    @Test(groups = {"A"},priority = 2)
    public void RegRun()
    {
        System.out.println("Reg");
    }

    @Test(groups = {"B"},priority = 3)
    public void SmokeRun()
    {
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }

    @Test(groups = {"qa", "prod"},priority = 3)
    public void QARun()
    {
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }

    @Test(groups = {"prod"},priority = 3)
    public void ProdRun()
    {
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }
}
