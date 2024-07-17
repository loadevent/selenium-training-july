package chapter4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Exercise4_1 {
    public static void main(String[] args) {
        boolean isValid = false;
        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement heading = driver.findElement(By.cssSelector("#content > h2"));
        isValid = heading.getText().equals("Available Examples");
        System.out.println(isValid);
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[14]/a")).click();

        WebElement loadedElementsHeading = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
        isValid = loadedElementsHeading.getText().equals("Dynamically Loaded Page Elements");
        System.out.println(isValid);

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[1]")).click();

        WebElement exampleHeading = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h4"));
        isValid = exampleHeading.getText().equals("Example 1: Element on page that is hidden");
        System.out.println(isValid);

        driver.findElement(By.xpath("//button[normalize-space()='Start']")).click();
        //wait
        WebElement lblFinish = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"finish\"]/h4")));
        isValid = lblFinish.getText().equals("Hello World!");
        System.out.println(isValid);

    }
}
