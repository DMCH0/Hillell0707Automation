package homeworks.homework29;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class BasketPageLogic extends  SearchPageLogic{
    SelenideElement titleOfProductInCart = $(By.xpath("//a[contains(@class, 'cart-product__title')]"));


    public  String getTitleOnBasket (){
        return titleOfProductInCart.shouldBe(Condition.visible).text().trim();

    }
    public BasketPageLogic checkTitlesFromSearchAndBasket (){
       Assert.assertEquals(getTitleOnBasket(),searchPageTitle());
        return page(BasketPageLogic.class);
    }
}
