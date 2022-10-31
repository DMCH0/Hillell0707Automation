package lesson24;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class getWindowHendles {

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
    public void methodIsSelected() {

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='header__button ng-star-inserted']"));
        loginButton.click();


        WebElement registerButton = driver.findElement(By.xpath("//button[contains(@class, 'auth-modal__register')]"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", registerButton);

        WebElement userAgreement = driver.findElement(By.xpath("//a[contains(@class, 'button button--link')]"));
        userAgreement.click();

        String mainTab = driver.getWindowHandle();

    }
}

