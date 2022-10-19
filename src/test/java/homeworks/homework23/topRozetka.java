package homeworks.homework23;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class topRozetka {
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
    public void topSales() throws InterruptedException {

        WebElement menuCategories = driver.findElement(By.xpath("//a[@class='menu-categories__link']"));
        menuCategories.click();
        WebElement laptopCategory = driver.findElement(By.xpath("//a[@href='https://rozetka.com.ua/ua/notebooks/c80004/']"));
        laptopCategory.click();
        WebElement salerRozetka = driver.findElement(By.xpath("//a[@data-id='Rozetka']"));
        salerRozetka.click();
        Thread.sleep(3000);
        WebElement maxSliderInputFied = driver.findElement(By.xpath("//input[@formcontrolname='max']"));
        maxSliderInputFied.clear();
        maxSliderInputFied.sendKeys("100000");
        WebElement sliderFilterSubmit = driver.findElement(By.xpath("//button[@class='button button_color_gray button_size_small slider-filter__button']"));
        sliderFilterSubmit.click();
        Thread.sleep(3000);

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
        WebElement firstProductAfterSearch = driver.findElement(By.xpath("//img[@title='Ноутбук Lenovo V14 G2 ITL (Intel i3-1115G4/8/128F/int/W10Pro) Black']"));
        firstProductAfterSearch.click();

        WebElement topSalesLabel = driver.findElement(By.xpath("//rz-label[@class='main-slider__label ng-star-inserted']"));
        Assert.assertTrue(topSalesLabel.isDisplayed(),"Label doesn't displayed on the page");
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
