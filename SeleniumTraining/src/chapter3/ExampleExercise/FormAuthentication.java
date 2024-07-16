package chapter3.ExampleExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormAuthentication {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[21]/a")).click();

        try {
            Thread.sleep(5000);

            WebElement txtUsername = driver.findElement(By.id("username"));
            WebElement txtPassword = driver.findElement(By.id("password"));
            txtUsername.sendKeys("tomsmith");
            txtPassword.sendKeys("SuperSecretPassword!");

            WebElement btnLogin = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
            btnLogin.click();

            WebElement btnLogout = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));

            if (btnLogout.isDisplayed()){
                System.out.println("Successful");
            }else{
                System.out.println("Invalid username or password");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        String url = "https://the-internet.herokuapp.com/secure";
//
//        if (url.equals(driver.getCurrentUrl())){
//            System.out.println("Successful");
//        }else{
//            System.out.println("Invalid username or password");
//        }
    }
}
