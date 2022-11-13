package homeworks.homework29;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class BasketPageLogic {
    SelenideElement titleOfProductInCart = $(By.xpath("//a[contains(@class, 'cart-product__title')]"));

    public  String getTitleOnBasket (){
        return titleOfProductInCart.shouldBe(Condition.visible).text().trim();
    }
}
