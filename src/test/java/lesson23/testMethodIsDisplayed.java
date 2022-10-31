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

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class testMethodIsDisplayed {
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
    public void rozetkaProduct() throws IOException {

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys("Mac");

        WebElement searchButton = driver.findElement(By.cssSelector("button.button_color_green"));
        searchButton.click();

        WebElement firstProduct = wait
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.goods-tile__title")));
        firstProduct.click();

        WebElement productPageTitle = driver.findElement(By.xpath("//h1[@class='product__title']"));
        WebElement productPrice = driver.findElement(By.xpath("//p[@class='product-prices__big']"));
        WebElement availabilityOfProduct = driver.findElement(By.xpath("//p[@class='status-label status-label--green ng-star-inserted']"));

        String productPageTitleText = productPageTitle.getAttribute("innerText").trim();
        String productPriceText = productPrice.getText();
        String availabilityOfProductColor = availabilityOfProduct.getCssValue("color");

        if (availabilityOfProduct.isDisplayed() && availabilityOfProductColor.equals("rgba(0, 160, 70, 1)")) {
            FileWriter fileWriter = new FileWriter("rozetkaTest1");
            fileWriter.write(productPageTitleText + "-" + productPriceText);
            fileWriter.close();
        }
    }
//    @AfterMethod
//    public void after() {
//        driver.quit();
//    }
}
