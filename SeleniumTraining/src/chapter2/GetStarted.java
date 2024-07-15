package chapter2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class GetStarted {
    public static void main(String[] args) {
        //Declare and initialize a webdriver object
        WebDriver driver = new EdgeDriver();
        //open URL
        driver.get("https://www.selenium.dev/projects/");
        //maximize the window
        driver.manage().window().maximize();
        System.out.println("Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Window ID: " + driver.getWindowHandle());
        System.out.println("----------------------------------");

        //navigate to a different URL
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.ilabquality.com/");
        driver.navigate().to("https://www.ilabquality.com/training/");

        System.out.println("Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Window ID: " + driver.getWindowHandle());
        //navigate back
        driver.navigate().back();

    }
}
