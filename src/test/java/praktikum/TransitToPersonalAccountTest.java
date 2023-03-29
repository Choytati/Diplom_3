package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import praktikum.pom.*;

public class TransitToPersonalAccountTest extends BaseTest {

    private RegistrationTestData registrationTestData;

    @Test
    @DisplayName("Проверка перехода со страницы Личного кабинета на Главную страницу")
    @Description("Базовый тест для перехода с помощью кнопки \"Личный кабинет\"")
    public void checkTransitWithPersonalAccountButton() {

        registrationTestData = RegistrationTestDataGenerator.getValidData();

        new RegistrationPage(driver)
                .openRegistrationPage()
                .setName(registrationTestData.name)
                .setEmail(registrationTestData.email)
                .setPassword(registrationTestData.password)
                .clickRegistrationButton();
        new LoginPage(driver)
                .openLoginPage()
                .setEmail(registrationTestData.email)
                .setPassword(registrationTestData.password)
                .clickEnterButton();
        new MainPage(driver)
                .clickPersonalAccountButton();

        boolean isProfileButtonDisplayed = new AccountPage(driver).isProfileButtonDisplayed();
        Assert.assertTrue("Не произошел переход в ЛК: ", isProfileButtonDisplayed);
    }
}
