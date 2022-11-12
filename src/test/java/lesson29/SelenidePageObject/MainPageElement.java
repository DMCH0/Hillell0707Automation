package lesson29.SelenidePageObject;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class MainPageElement  {

    ElementsCollection sideBarMenu = $$(By.xpath("//a[@class='menu-categories__link']"));

}
