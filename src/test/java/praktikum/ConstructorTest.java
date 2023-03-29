package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import praktikum.pom.MainPage;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Проверка перехода в раздел булочек")
    @Description("Базовый тест для конструктора на главной странице")
    public void checkTransitToBuns() {

        String bunsParentAttribute =
                new MainPage(driver)
                        .openMainPage()
                        .clickSaucesPointer()
                        .clickBunsPointer()
                        .getAttributeBunsPointerParent();
        boolean isAttributeContainsCurrent = bunsParentAttribute.contains("current");
        Assert.assertTrue("Переход к разделу не произошел: ", isAttributeContainsCurrent);
    }

    @Test
    @DisplayName("Проверка перехода в раздел соусов")
    @Description("Базовый тест для конструктора на главной странице")
    public void checkTransitToSauces() {

        String saucesParentAttribute =
                new MainPage(driver)
                        .openMainPage()
                        .clickSaucesPointer()
                        .getAttributeSaucesPointerParent();
        boolean isAttributeContainsCurrent = saucesParentAttribute.contains("current");
        Assert.assertTrue("Переход к разделу не произошел: ", isAttributeContainsCurrent);
    }

    @Test
    @DisplayName("Проверка перехода в раздел начинки")
    @Description("Базовый тест для конструктора на главной странице")
    public void checkTransitToFillings() {

        String fillingsParentAttribute =
                new MainPage(driver)
                        .openMainPage()
                        .clickFillingsPointer()
                        .getAttributeFillingsPointerParent();
        boolean isAttributeContainsCurrent = fillingsParentAttribute.contains("current");
        Assert.assertTrue("Переход к разделу не произошел: ", isAttributeContainsCurrent);
    }
}
