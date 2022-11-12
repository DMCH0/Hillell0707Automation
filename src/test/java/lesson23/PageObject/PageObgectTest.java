package lesson23.PageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class PageObgectTest {

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
//    @Test
//    public  void  rozetkaTets() throws InterruptedException, IOException{
//        new MainPageLogic(driver, wait)
//                .typeTextToSearchInput("Mac")
//                .clickFindBtn();
//        SearchPageLogic searchPageLogic = new SearchPageLogic(driver, wait);
//        String titleFromSearchPage = searchPageLogic.firstProductTitleText();
//        searchPageLogic.clickOnFirstProduct();
//
//        String titleTextFromProductPage = new ProductPageLogic(driver, wait).getTitleText();
//        Assert.assertEquals(titleFromSearchPage, titleTextFromProductPage);
//    }
    @AfterMethod
    public void after() {
        driver.quit();
    }
}
