package chapter4;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitStrategies {
    static WebDriver driver;
    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        //theImplicitWait();
        //theExplicitWait();
        theFluentWait();
    }

    static void theImplicitWait(){
        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//input[@placeholder='Username']"))
                .sendKeys("Admin");
        driver.findElement(By.id("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"))
                .sendKeys("admin123");
        WebElement btnLogin = driver.findElement(By.xpath("//button"));
        btnLogin.click();
    }

    static void theExplicitWait(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Username']")))
                .sendKeys("Admin");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")))
                .sendKeys("admin123");

        WebElement btnLogin = driver.findElement(By.xpath("//button"));
        btnLogin.click();
    }

    static void theFluentWait(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//input[@placeholder='Username']"))
                .sendKeys("Admin");
        driver.findElement(By.id("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"))
                .sendKeys("admin123");

        WebElement btnLogin = driver.findElement(By.xpath("//button"));
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin));

        btnLogin.click();

    }
}
