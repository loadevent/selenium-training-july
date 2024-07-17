package chapter6;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

public class TakingScreenShots {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/abtest");
        driver.manage().window().maximize();
        //wait
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
//        driver.findElement(By.xpath("//input[@placeholder='Username']"))
//                .sendKeys(username);
//
//        driver.findElement(By.xpath("//input[@placeholder='Password']"))
//                .sendKeys(password);
//
//        WebElement btnLogin = driver.findElement(By.xpath("//button"));
//        btnLogin.click();
        //Take screenshot
        try{
            Thread.sleep(5);
            File srcFile = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            String fileName = "_[" + timeStamp + "].png";
            //Files.copy(srcFile,new FileOutputStream("src/test/resources/screenshots/screenshot200.png"));
            //                                     src/test/resources/screenshots/screenshot_[" + timeStamp + "].png
            Files.move(srcFile,new File("src/test/resources/screenshots/screenshot" + fileName));

        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }



    }
}
