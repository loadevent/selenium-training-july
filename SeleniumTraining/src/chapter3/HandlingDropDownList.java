package chapter3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class HandlingDropDownList {
    static WebDriver driver;
    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        driver.manage().window().maximize();

        fillInTheForm();
    }
    static void fillInTheForm(){
        WebElement txtName = driver.findElement(By.name("name"));
        WebElement txtEmail = driver.findElement(By.name("email"));
        WebElement rdoGender = driver.findElement(By.id("gender"));
        WebElement txtMobile = driver.findElement(By.id("mobile"));
        WebElement txtSubject = driver.findElement(By.cssSelector("input.form-control[id=subjects]"));
        WebElement txtAddress = driver.findElement(By.xpath("//textarea[@id='picture']"));
        WebElement stateOption = driver.findElement(By.id("state"));
        WebElement cityOption = driver.findElement(By.id("city"));

        txtName.sendKeys("Kabelo");
        txtEmail.sendKeys("kabelo@gmail.com");
        txtMobile.sendKeys("01234569871");
        txtSubject.sendKeys("Java");
        rdoGender.click();
        txtAddress.sendKeys("123 Penelope Street");

        //Select options
        Select slState = new Select(stateOption);
        Select slCity = new Select(cityOption);

        slState.selectByValue("Haryana");
        //slCity.selectByVisibleText("Lucknow");
        slCity.selectByIndex(1);
    }
}
