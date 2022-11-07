package lesson28;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideFirstRozetkaTest {
    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1920x1080";
        open("https://rozetka.com.ua/ua/");
    }
    @Test
    public void firstTest(){
        SelenideElement findBtn = $(byXpath("//*[text()=' Знайти ']"));
        String textFromFindBtn = findBtn.text();  // через метод text() получим текст с кнопки  Найти
        System.out.println(textFromFindBtn);

        String fromActionAttrFromFindBtn = findBtn.attr("formAction"); // находим аттрибут Prorerties
        System.out.println(fromActionAttrFromFindBtn);

        String backGroundFromFindBtn = findBtn.getCssValue("background-color"); //находим CSS свойство элемента
        System.out.println(backGroundFromFindBtn);


    }
}
