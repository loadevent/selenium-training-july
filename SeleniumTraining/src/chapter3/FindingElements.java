package chapter3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/*
 * Finding web elements using different locators
 */
public class FindingElements {
    public static void main(String[] args) {
        //getMultipleElements();

        WebDriver driver = new ChromeDriver();
        //open url
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        //WebElement linkAbTesting = driver.findElement(By.linkText("A/B Testing"));
        WebElement linkAbTesting = driver.findElement(By.partialLinkText("Dynamic"));
        System.out.println("Element Found");
        System.out.println("Text: " + linkAbTesting.getText());
        System.out.println("Tag: " + linkAbTesting.getTagName());
        System.out.println("Position X: " + linkAbTesting.getLocation().x);
        System.out.println("Position Y: " + linkAbTesting.getLocation().y);
        System.out.println("Accessible Name: " + linkAbTesting.getAccessibleName());
        System.out.println("Height: " + linkAbTesting.getSize().height);
    }

    public static void getMultipleElements(){
        WebDriver driver = new ChromeDriver();
        //open url
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        List<WebElement> dynamicLinks = driver.findElements(By.partialLinkText("File"));

        for (WebElement link : dynamicLinks){
            System.out.println("Text: " + link.getText());
            System.out.println("-------------------------------------");
        }
    }
}
