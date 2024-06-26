package TestNG;

import org.testng.annotations.Test;

public class prog6
{

    // if same priority then it will execute in alphabetical or numeric order
    @Test(priority = 1)
    public void testMethodB() {
        System.out.println("Test Method B");
    }

    @Test(priority = 1)
    public void testMethodA() {
        System.out.println("Test Method A");
    }


    @Test(priority = 1)
    public void testMethodC() {
        System.out.println("Test Method C");
    }
}

/*  output:
    Test Method A, B, C
*/
