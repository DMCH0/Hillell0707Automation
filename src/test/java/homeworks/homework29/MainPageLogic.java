package homeworks.homework29;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPageLogic {

    SelenideElement categoriesLaptopsAndPc = $(By.xpath("//a[@class='menu-categories__link']"));

    public CategoryPageLogic clickOnCategoryMainPage (SelenideElement category){
        category.shouldBe(Condition.visible);
        category.click();
        return page(CategoryPageLogic.class);
    }

}
