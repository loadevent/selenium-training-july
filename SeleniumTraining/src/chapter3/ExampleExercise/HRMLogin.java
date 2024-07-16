package chapter3.ExampleExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HRMLogin {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Username']")))
                .sendKeys("Admin");
            //driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")))
                        .sendKeys("admin123");
            //driver.findElement(By.id("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
            WebElement btnLogin = driver.findElement(By.xpath("//button"));
            btnLogin.click();

            String url = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
            boolean isSuccess = url.equals(driver.getCurrentUrl());

            if (isSuccess){
                System.out.println("Successful Login");
            }else{
                System.err.println("Error");
            }
    }
}
