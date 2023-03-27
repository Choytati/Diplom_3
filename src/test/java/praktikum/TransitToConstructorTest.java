package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import praktikum.pom.*;

public class TransitToConstructorTest extends BaseTest {

    private RegistrationTestData registrationTestData;

    @Test
    @DisplayName("Проверка перехода со страницы Личного кабинета на Главную страницу")
    @Description("Базовый тест для перехода с помощью кнопки конструктора")
    public void checkTransitWithConstructorButton() {

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
        new AccountPage(driver)
                .clickConstructorButton();

        boolean isSetBuggerTitleDisplayed = new MainPage(driver).isSetBuggerTitleDisplayed();
        Assert.assertTrue("Не произошел переход в Конструктор: ", isSetBuggerTitleDisplayed);
    }

    @Test
    @DisplayName("Проверка перехода со страницы Личного кабинета на Главную страницу")
    @Description("Базовый тест для перехода с помощью кнопки \"Stellar Burgers\"")
    public void checkTransitWithLogoStellarBurgers() {

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
        new AccountPage(driver)
                .clickLogoStellarBurgers();

        boolean isSetBuggerTitleDisplayed = new MainPage(driver).isSetBuggerTitleDisplayed();
        Assert.assertTrue("Не произошел переход в Конструктор: ", isSetBuggerTitleDisplayed);
    }
}

