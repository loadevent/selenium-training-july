package chapter3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementsLocators {
    static WebDriver driver;
    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        driver.manage().window().maximize();

        locateByName();
       locateById();
        locateByCSS();

    }

    public static void locateByName(){
        WebElement txtName = driver.findElement(By.name("name"));
        WebElement txtEmail = driver.findElement(By.name("email"));

        //Type into the text boxes
        txtName.sendKeys("Kabelo");
        txtEmail.sendKeys("kabelo@gmail.com");

        System.out.println("===============NAME=====================");
        System.out.println("Accessible Name: " + txtName.getAccessibleName());
        System.out.println("Tag: " + txtName.getTagName());

        System.out.println("===============EMAIL=====================");
        System.out.println("Accessible Name: " + txtEmail.getAccessibleName());
        System.out.println("Tag: " + txtEmail.getTagName());
    }

    public static void locateById(){
        WebElement rdoGender = driver.findElement(By.id("gender"));
        WebElement txtMobile = driver.findElement(By.id("mobile"));

        txtMobile.sendKeys("01234569871");
        rdoGender.click();

        System.out.println("===============GENDER=====================");
        System.out.println("Accessible Name: " + rdoGender.getAccessibleName());
        System.out.println("Tag: " + rdoGender.getTagName());

        System.out.println("===============MOBILE=====================");
        System.out.println("Accessible Name: " + txtMobile.getAccessibleName());
        System.out.println("Tag: " + txtMobile.getTagName());
    }

    public static void locateByCSS(){

        //WebElement txtName = driver.findElement(By.cssSelector("input[id=name]"));
        WebElement txtSubject = driver.findElement(By.cssSelector("input.form-control[id=subjects]"));
        txtSubject.sendKeys("Java");

//        System.out.println("===============NAME (CSS)=====================");
//        System.out.println("Accessible Name: " + txtName.getAccessibleName());
//        System.out.println("Tag: " + txtName.getTagName());

        System.out.println("===============SUBJECT (CSS)=====================");
        System.out.println("Accessible Name: " + txtSubject.getAccessibleName());
        System.out.println("Tag: " + txtSubject.getTagName());

    }

}
