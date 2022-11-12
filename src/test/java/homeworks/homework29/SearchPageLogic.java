package homeworks.homework29;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class SearchPageLogic {

    ElementsCollection firstProductInList = $$(By.xpath("//span[@class='goods-tile__title']"));
    SelenideElement addToBasketButton = $(By.xpath("//app-buy-button[@extclass='goods-tile__buy-button']"));
    SelenideElement basketCounter = $(By.xpath("//span[contains(@class, 'counter--green')]"));

    public SearchPageLogic checkProductTitleSearchPage(int titleOfFirstProductIndex){
        
        String productTitleOnsearchPage = firstProductInList.get(0).shouldBe(Condition.visible).getText();
        System.out.println(productTitleOnsearchPage);
        return page(SearchPageLogic.class);
    }

    public SearchPageLogic addToBasketButton(SelenideElement addToBasketButton) {
        addToBasketButton.shouldBe(Condition.visible).click();
        return this;
    }

    public  SearchPageLogic countInBasket (String CountSize){
        String countAttribute = basketCounter.shouldBe(Condition.visible).getAttribute("innerText");
        Assert.assertEquals(countAttribute,CountSize);
       return this;
    }

    public BasketPageLogic clickOnBasketCounter (SelenideElement clickOnBasket) {
        clickOnBasket.shouldBe(Condition.visible).click();
        return page(BasketPageLogic.class);
    }
}
