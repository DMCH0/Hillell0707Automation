package homeworks.homework29;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class Main {


    private final MainPageLogic MAIN_PAGE_LOGIC = new MainPageLogic();

    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1730x950";
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void homeWork29() {

        MAIN_PAGE_LOGIC
                .clickOnCategory(MAIN_PAGE_LOGIC.categoriesLaptopsAndPc)
                .clickOnCategory(new CategoryPageLogic().laptops)
                .checkProductTitleSearchPage(0)
                .addToBasketButton(new SearchPageLogic().addToBasketButton)
                .countInBasket("1")
                .clickOnBasketCounter(new SearchPageLogic().basketCounter)
                .checkProductTitleBasket(new BasketPageLogic().titleOfProductInCart);



        sleep(1000);

    }
}
