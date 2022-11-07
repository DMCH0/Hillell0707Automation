package homeworks.homework28;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideAddToBasket {

    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1730x950";
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void addToBasket() {

        $(By.xpath("//a[@class='menu-categories__link']"))
                .click();

        $(By.xpath("//a[contains(@href, '/ua/notebooks/c80004/')]"))
                .click();

        SelenideElement firstProductInList = $(By.xpath("//span[@class='goods-tile__title']"));
        String titleOfFirstProductInList = firstProductInList.text();

        $(By.xpath("//app-buy-button[@extclass='goods-tile__buy-button']"))
                .click();

        $(By.xpath("//span[contains(@class, 'counter--green')]"))
                .shouldHave(text("1"))
                .click();

        SelenideElement titleOfProductInCart = $(By.xpath("//a[contains(@class, 'cart-product__title')]"));
        String productTitleInCart = titleOfProductInCart.text();

        Assert.assertEquals(titleOfFirstProductInList, productTitleInCart);
        // productTitleInCart.equals(titleOfFirstProductInList);

    }
}
