package lesson23;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class testCheckingColorByCssValue {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUpTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaProduct() {

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys("Mac");

        WebElement searchButton = driver.findElement(By.cssSelector("button.button_color_green"));
        searchButton.click();

        WebElement firstProduct = wait
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.goods-tile__title")));
        firstProduct.click();

        WebElement firstActiveLink = driver.findElement(By.xpath("//a[@class='tabs__link tabs__link--active']"));
        String colorOfFirstActiveLink = firstActiveLink.getCssValue("color");

        Assert.assertEquals(colorOfFirstActiveLink, "rgba(0, 160, 70, 1)", "Color of element isn't green ");


    }
    @AfterMethod
    public void after() {
        driver.quit();
    }
}
