package lesson22;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class rozetkaFirstTest {
    final String EXPECTED_TITLE = "Комп'ютер Apple Mac Studio M1 Ultra/48 ядер GPU/64GB/1TB";
    private WebDriver driver;

    @BeforeMethod
    public void setUpTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTest() throws InterruptedException {

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys("Mac");

        WebElement buttonSearch = driver.findElement(By.xpath("//*[text()=' Знайти ']"));
//        buttonSearch.click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", buttonSearch);

        TimeUnit.SECONDS.sleep(10);

        WebElement firstProduct = driver.findElement(By.xpath("span.goods-tile__title"));
        String titleOfFirstProduct = firstProduct.getText().trim();
        Assert.assertEquals(titleOfFirstProduct, EXPECTED_TITLE);


    }
    @AfterTest
    public void after(){
        driver.quit();
    }
}
