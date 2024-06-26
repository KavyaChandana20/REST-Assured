package TestNG.Priority;

import org.testng.annotations.Test;

public class prog1
{
    @Test(priority = 1)
    public void testMethodOne() {
        System.out.println("Test Method 1");
    }

    @Test(priority = 2)
    public void testMethodTwo() {
        System.out.println("Test Method 2");
    }

    @Test(priority = 0)
    public void testMethodZero() {
        System.out.println("Test Method 3");
    }

    @Test(priority = -1)
    public void testMethodNegativeOne() {
        System.out.println("Test Method -5");
    }
}
/*  output:
    Test Method -5, 3, 1, 2
*/