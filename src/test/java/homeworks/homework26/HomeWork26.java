package homeworks.homework26;

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

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HomeWork26 {
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
    public void saveProductsToMap() throws InterruptedException, IOException {

        WebElement menuCategories = driver.findElement(By.xpath("//a[@class='menu-categories__link']"));
        menuCategories.click();

        WebElement laptopCategory = driver.findElement(By.xpath("//*[contains(@href, 'c80004')]"));
        laptopCategory.click();

        TimeUnit.SECONDS.sleep(1);

        List<WebElement> titlesOfGoods = driver.findElements(By.cssSelector(".goods-tile__inner .goods-tile__title"));
        int countOfProductTitles = titlesOfGoods.size();
        Assert.assertEquals(countOfProductTitles, 60);


        List<WebElement> productPrices = driver.findElements(By.cssSelector(".goods-tile__inner .goods-tile__price-value"));
        int countPrices = productPrices.size();
        Assert.assertEquals(countPrices, 60);

        Map<String, Integer > map = new HashMap<>();
        for (int i = 0 ; i < titlesOfGoods.size(); i++){
            map.put(titlesOfGoods.get(i).getText(), Integer.parseInt(productPrices.get(i).getText().replaceAll(" ","")));
        }

        FileWriter fileWriter = new FileWriter("rozetkaTitlesAndPrices.txt");
        for (Map.Entry <String, Integer> entry : map.entrySet()) {
            fileWriter.write( entry.getKey() + " - " + entry.getValue() + "\n");
        }
            fileWriter.close();
      }
    @AfterMethod
    public void after() {
        driver.quit();
    }
}
