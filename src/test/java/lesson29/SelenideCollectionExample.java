package lesson29;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.source;
import static com.codeborne.selenide.WebDriverRunner.url;

public class SelenideCollectionExample {
    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1730x950";
        open("https://rozetka.com.ua/ua/");
    }
    @Test
    public void example() {
        ElementsCollection sideBarMenu = $$(By.xpath("//a[@class='menu-categories__link']"));
        int sizeCollection = sideBarMenu.size();
        System.out.println(sizeCollection);
         String text = sideBarMenu.get(1).getText(); // Получаем текс элемента по индексу в коллекции (начиная с 0)
        System.out.println(text);
        sideBarMenu.shouldHave(CollectionCondition.size(16));

        ElementsCollection sideBArMenuWithFilter = sideBarMenu.filterBy(Condition.text("Смартфони, ТВ і електроніка"));
        System.out.println(sideBArMenuWithFilter.size() + " sideBArMenuWithFilter size");

        String currentUrl = url();
        System.out.println(currentUrl);

        String source = source(); // выведет код страницы
        System.out.println(source);
    }

}
