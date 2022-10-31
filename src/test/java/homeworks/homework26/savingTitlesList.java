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
import  java.io.IOException;
import java.io.FileWriter;
import java.sql.Time;
import java.time.Duration;
import java.util.*;

public class savingTitlesList {

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
    public void checkFirstsProductTitles() throws InterruptedException, IOException {

        WebElement menuCategories = driver.findElement(By.xpath("//a[@class='menu-categories__link']"));
        menuCategories.click();

        WebElement laptopCategory = driver.findElement(By.xpath("//a[contains(@href, '/ua/notebooks/c80004/')]"));
        laptopCategory.click();


        List<WebElement> titlesOfGoods = driver.findElements(By.cssSelector(".goods-tile__inner .goods-tile__title"));
        int countOfProductTitles = titlesOfGoods.size();
        Assert.assertEquals(countOfProductTitles, 60);

        Thread.sleep(6000);
        List<String> test = new ArrayList<>();
        for ( int i = 0; i < titlesOfGoods.size(); i++){
            test.add(titlesOfGoods.get(i).getText());
        }

        Thread.sleep(2000);
        System.out.println(test);

//        List<WebElement> productPrices = driver.findElements(By.cssSelector(".goods-tile__inner .goods-tile__price-value"));
//        int countPrices = productPrices.size();
//        Assert.assertEquals(countPrices, 60);
//        for (WebElement pricesText : productPrices ){
//            pricesText.getText();
//        }
//
//        HashMap<List<WebElement>, List<WebElement>> titlesAndPrices = new HashMap<>();


//        FileWriter fileWriter = new FileWriter("rozetkaTitlesAndPrices1");
//        fileWriter.write(productT + "");
//        fileWriter.close();
//
//    }
//      @AfterMethod
//    public void after() {
//        driver.quit();
  }
    public void myClick(By element) {  //метод для клика обновляющихся ID
        try {
            driver.findElement(element).click();
        }catch (org.openqa.selenium.StaleElementReferenceException e){
            System.out.println("HERE " + element);
            driver.findElement(element).click();
        }
    }
}

