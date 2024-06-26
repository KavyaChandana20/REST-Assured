package TestNG;

import org.testng.annotations.Test;

public class prog9
{
    @Test(groups = { "init" },priority = 1)
    public void start() {
        System.out.println("Server Started Ok");
    }

    @Test(groups = { "init" },priority = 2)
    public void stop() {
        System.out.println("Server Stopped Ok");
    }

    @Test(dependsOnGroups = { "init.*" }) // after running the all the "init" groups this method will run
    public void last() {
        System.out.println("Now I will run");
    }
}
