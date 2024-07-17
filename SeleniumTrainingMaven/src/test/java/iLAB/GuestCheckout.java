package iLAB;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GuestCheckout {
    private WebDriver driver;
    private ExtentReports extent;
    private ExtentSparkReporter reporter;
    private String reportUri = "src/test/resources/reports/Product Checkout.html";

    @BeforeAll
    @DisplayName("Set up")
     void setUp(){
        //Set up the driver
        driver = new ChromeDriver();
        driver.get("https://askomdch.com/");
        driver.manage().window().maximize();
        //set up the report
        extent = new ExtentReports();
        reporter = new ExtentSparkReporter(reportUri);
        extent.attachReporter(reporter);
    }

    @AfterEach
    @DisplayName("Taking Screenshots")
    void takeScreenShot(TestInfo info){

        ExtentTest myTest = extent.createTest(info.getDisplayName());
        try {
            File srcFile = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            String fileName = info.getDisplayName() + "_[" + timeStamp + "].png";
            //Files.copy(srcFile,new FileOutputStream("src/test/resources/screenshots/screenshot200.png"));
            //
            //                                     src/test/resources/screenshots/screenshot_[" + timeStamp + "].png
           File destFile = new File("src/test/resources/screenshots/" + fileName);
           Files.move(srcFile,destFile);
           myTest.addScreenCaptureFromPath(destFile.getAbsolutePath());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    @DisplayName("Open Store Page")
    @Order(1)
    void openStorePage(){
        driver.findElement(By.xpath("//*[@id=\"menu-item-1227\"]/a")).click();
        //search
        driver.findElement(By.xpath("//*[@id=\"woocommerce-product-search-field-0\"]"))
                .sendKeys("shoes");
        driver.findElement(By.xpath("//*[@id=\"woocommerce_product_search-1\"]/form/button"))
                .click();
        //verify results
        WebElement searchHeading = driver.findElement(By.xpath("//*[@id=\"main\"]/div/header/h1"));
        String expectedResults = "Search results: “shoes”";
        assertEquals(expectedResults,searchHeading.getText());
    }

    @Test
    @DisplayName("Add Item To Cart")
    @Order(2)
    void addItemToCart(){
        //select red shoes
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/ul/li[2]/div[2]/a[2]")).click();
        WebElement linkViewCart = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='View cart']")));
        linkViewCart.click();
    }

    @Test
    @DisplayName("Proceed To Checkout")
    @Order(3)
    void proceedToCheckout(){
        //click the checkout button
        driver.findElement(By.cssSelector(".checkout-button.button.alt.wc-forward")).click();
        String expected = "https://askomdch.com/checkout/";
        String actual = driver.getCurrentUrl();
        //verify url
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Enter Billing Info")
    @Order(4)
    void enterBillingDetails(){
        //provide billing details
        driver.findElement(By.id("billing_first_name")).sendKeys("Kabelo");
        driver.findElement(By.id("billing_last_name")).sendKeys("Tlhape");

        WebElement countryOptions = driver.findElement(By.id("billing_country"));
        Select country = new Select(countryOptions);
        country.selectByVisibleText("South Africa");

        driver.findElement(By.id("billing_address_1")).sendKeys("123");
        driver.findElement(By.id("billing_address_2")).sendKeys("Penelope");
        driver.findElement(By.id("billing_postcode")).sendKeys("0111");
        driver.findElement(By.id("billing_city")).sendKeys("Pretoria");

        WebElement provinceOptions = driver.findElement(By.id("billing_state"));
        Select province = new Select(provinceOptions);
        province.selectByVisibleText("Gauteng");

        driver.findElement(By.id("billing_email")).sendKeys("kabelo@gmail.com");

        //click place order button
        WebElement btnPlaceOrder = driver.findElement(By.id("place_order"));
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(6))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(ElementClickInterceptedException.class);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("place_order")));
        btnPlaceOrder.click();

    }

    @AfterAll
    @DisplayName("Closing resources")
    void tearDown(){

        try {
            driver.quit();
            extent.flush();
            Desktop.getDesktop().browse(new File(reportUri).toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
