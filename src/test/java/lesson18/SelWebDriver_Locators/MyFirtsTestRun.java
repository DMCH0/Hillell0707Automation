package lesson18.SelWebDriver_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyFirtsTestRun {

    private WebDriver driver;
    @BeforeTest
    public void setUpTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void firtsRun(){
        driver.get("https://rozetka.com.ua");
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']"));


    }
}
