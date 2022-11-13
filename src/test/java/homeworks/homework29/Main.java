package homeworks.homework29;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
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
                .clickOnCategoryMainPage(MAIN_PAGE_LOGIC.categoriesLaptopsAndPc)
                .clickOnCategoryCategoryPage(new CategoryPageLogic().laptops)
                .addToBasketButton(new SearchPageLogic().addToBasketButton)
                .countInBasket("1")
                .clickOnBasketCounter(new SearchPageLogic().basketCounter)
                .checkTitlesFromSearchAndBasket();

//        Реализовал два варианта проверки тайтлов, вариант ниже реализован по примеру из лекции (35. Practice + Page Object).
//        SearchPageLogic searchPageLogic = new SearchPageLogic();
//        String title = searchPageLogic.searchPageTitle();
//
//        BasketPageLogic basketPageLogic = new BasketPageLogic();
//        String basketTitle = basketPageLogic.getTitleOnBasket();
//
//        Assert.assertEquals(title, basketTitle);
        }
}
