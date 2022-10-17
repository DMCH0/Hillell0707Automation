package lesson18.SelWebDriver_Locators.lesson22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SecondTestRun {

    final String EXPECTED_TITLE_ROZETKA = "Комп'ютер Apple Mac Studio M1 Ultra/48 ядер GPU/64GB/1TB";
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTest(){

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys("Mac");
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']"));
        searchButton.click();

        String titleOfFirstProduct = searchButton.getText().trim();
    }
}
