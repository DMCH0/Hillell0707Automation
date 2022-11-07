package lesson28;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideFirstTest {

    @BeforeMethod
    public void before(){
        Configuration.browserSize = "1920x1080";
        open("https://rozetka.com.ua/ua/");
    }
    @Test
    public void firstSelenideTest() {
        $(By.name("search"))
                .setValue("Mac");
        $(By.xpath("//*[text()=' Знайти ']"))
                .shouldBe(visible)
                .shouldHave(text("Знайти"))
                .shouldNotHave(text("Alex"))
                        .click();

        sleep(5000);
    }
}
