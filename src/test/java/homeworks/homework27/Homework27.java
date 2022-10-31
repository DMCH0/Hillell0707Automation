package homeworks.homework27;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Homework27 {
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
    public void rozetkaPromotions(){

//        List<WebElement> promotionsList = driver.findElements(By.cssSelector(""));
//        int countOfProductTitles = promotionsList.size();
//        Assert.assertEquals(promotionsList, 6);

        WebElement promotionsList = driver.findElement(By.xpath("//ul[@class='main-goods__grid ng-star-inserted']"));
        int countPromotionList = Integer.parseInt(promotionsList.getAttribute("childElementCount").trim());
        Assert.assertEquals(countPromotionList, 6);

        WebElement firstPromotionProductPrice = driver.findElement(By.xpath("//span[@class='tile__price-value']"));
        String promotionProductPrice = firstPromotionProductPrice.getText();
        System.out.println(promotionProductPrice);

        WebElement firstProductInList = driver.findElement(By.cssSelector(".tile__inner .tile__title"));
        firstProductInList.click();

        WebElement productPriceOnProductPage = driver.findElement(By.xpath("//p[contains(@class, 'product-prices__big')]"));
        String productPriceValue = productPriceOnProductPage.getAttribute("textContent").trim();
        System.out.println(productPriceValue);
    }

}
