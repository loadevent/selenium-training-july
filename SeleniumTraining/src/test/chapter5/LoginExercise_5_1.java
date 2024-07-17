package chapter5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginExercise_5_1 {
    @ParameterizedTest
    @CsvSource(value = {"Admin,admin123","Admin,admin1234","AdminAd,admin123","Admin12,admin123123",})
    void verifySuccessfulLogin(String username, String password){
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        //wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//input[@placeholder='Username']"))
                .sendKeys(username);

        driver.findElement(By.xpath("//input[@placeholder='Password']"))
                .sendKeys(password);

        WebElement btnLogin = driver.findElement(By.xpath("//button"));
        btnLogin.click();

        //verify
        String expected = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String actual = driver.getCurrentUrl();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        assertEquals(expected,actual);

        driver.quit();

    }
}
