package homeworks.homework24;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class rozetkaAddToBasket {
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
    public void checkFirstsProductTitles() throws InterruptedException {

        WebElement menuCategories = driver.findElement(By.xpath("//a[@class='menu-categories__link']"));
        menuCategories.click();

        WebElement laptopCategory = driver.findElement(By.xpath("//a[contains(@href, '/ua/notebooks/c80004/')]"));
        laptopCategory.click();

        WebElement firstProductTitle = driver.findElement(By.xpath("//a[contains(@title, '(82KU01C4RA')]"));
        String titleOfFirstProduct = firstProductTitle.getText().trim();

        Thread.sleep(3000);
        WebElement addFirstProductToBasket = driver.findElement(By.xpath("//app-buy-button[@goods_id='349995669']/button"));
        addFirstProductToBasket.click();

        WebElement basketCounter = driver.findElement(By.xpath("//span[contains(@class, 'counter--green')]"));
        if (basketCounter.getAttribute("innerText").equals("1")) {
            basketCounter.click();
        } else {
            Assert.fail("Ваша корзина пуста или количество товаров больше чем 1");
        }
        WebElement titleOfProductInCart = driver.findElement(By.xpath("//a[contains(@class, 'cart-product__title')]"));
        String productTitleInCart = titleOfProductInCart.getText().trim();

        Assert.assertEquals(productTitleInCart, titleOfFirstProduct, " -Название товара на главной и в корзине не совпадает- ");
    }
    @AfterMethod
    public void after() {
        driver.quit();
    }
}


