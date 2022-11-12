package homeworks.homework29;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class BasketPageLogic{

    SelenideElement titleOfProductInCart = $(By.xpath("//a[contains(@class, 'cart-product__title')]"));

    public BasketPageLogic checkProductTitleBasket(SelenideElement titleOfProductInCart){
        String cartProductTitleInBasket = titleOfProductInCart.shouldBe(Condition.visible).text();
        System.out.println(cartProductTitleInBasket);
        return page(BasketPageLogic.class);
    }


}
