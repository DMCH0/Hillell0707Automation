package homeworks.homework29;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CategoryPageLogic {

    SelenideElement laptops =  $(By.xpath("//a[contains(@href, '/ua/notebooks/c80004/')]"));

    public SearchPageLogic clickOnCategoryCategoryPage(SelenideElement category) {
        category.shouldBe(Condition.visible);
        category.click();
        return page(SearchPageLogic.class);
    }
}
