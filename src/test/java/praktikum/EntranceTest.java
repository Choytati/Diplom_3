package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import praktikum.pom.*;

public class EntranceTest extends BaseTest {

    private RegistrationTestData registrationTestData;

    @Test
    @DisplayName("Проверка входа на главной странице с помощью кнопки \"Войти в учетную запись\"")
    @Description("Базовый тест для входа с валидными данными")
    public void checkEntranceWithEnterAccountButton() {

        registrationTestData = RegistrationTestDataGenerator.getValidData();

        new RegistrationPage(driver)
                .openRegistrationPage()
                .setName(registrationTestData.name)
                .setEmail(registrationTestData.email)
                .setPassword(registrationTestData.password)
                .clickRegistrationButton();
        new MainPage(driver)
                .openMainPage()
                .clickEnterAccountButton();
        new LoginPage(driver)
                .setEmail(registrationTestData.email)
                .setPassword(registrationTestData.password)
                .clickEnterButton();
        new MainPage(driver)
                .clickPersonalAccountButton();

        boolean isProfileButtonDisplayed = new AccountPage(driver).isProfileButtonDisplayed();
        Assert.assertTrue("Не произошел переход в ЛК:", isProfileButtonDisplayed);
    }

    @Test
    @DisplayName("Проверка входа на главной странице с помощью кнопки \"Личный кабинет\"")
    @Description("Базовый тест для входа с валидными данными")
    public void checkEntranceWithPersonalAccountButton() {

        registrationTestData = RegistrationTestDataGenerator.getValidData();

        new RegistrationPage(driver)
                .openRegistrationPage()
                .setName(registrationTestData.name)
                .setEmail(registrationTestData.email)
                .setPassword(registrationTestData.password)
                .clickRegistrationButton();
        new MainPage(driver)
                .openMainPage()
                .clickPersonalAccountButton();
        new LoginPage(driver)
                .setEmail(registrationTestData.email)
                .setPassword(registrationTestData.password)
                .clickEnterButton();
        new MainPage(driver)
                .clickPersonalAccountButton();

        boolean isProfileButtonDisplayed = new AccountPage(driver).isProfileButtonDisplayed();
        Assert.assertTrue("Не произошел переход в ЛК: ", isProfileButtonDisplayed);
    }

    @Test
    @DisplayName("Проверка входа со страницы \"Регистрация\"")
    @Description("Базовый тест для входа с валидными данными")
    public void checkEntranceWithEnterRegistrationPageButton() {

        registrationTestData = RegistrationTestDataGenerator.getValidData();

        new RegistrationPage(driver)
                .openRegistrationPage()
                .setName(registrationTestData.name)
                .setEmail(registrationTestData.email)
                .setPassword(registrationTestData.password)
                .clickRegistrationButton()
                .openRegistrationPage()
                .clickEnterButton();
        new LoginPage(driver)
                .setEmail(registrationTestData.email)
                .setPassword(registrationTestData.password)
                .clickEnterButton();
        new MainPage(driver)
                .clickPersonalAccountButton();

        boolean isProfileButtonDisplayed = new AccountPage(driver).isProfileButtonDisplayed();
        Assert.assertTrue("Не произошел переход в ЛК: ", isProfileButtonDisplayed);
    }

    @Test
    @DisplayName("Проверка входа со страницы \"Восстановление пароля\"")
    @Description("Basic test for login with valid credentials")
    public void checkEntranceWithEnterForgotPasswordPageButton() {

        registrationTestData = RegistrationTestDataGenerator.getValidData();

        new RegistrationPage(driver)
                .openRegistrationPage()
                .setName(registrationTestData.name)
                .setEmail(registrationTestData.email)
                .setPassword(registrationTestData.password)
                .clickRegistrationButton();
        new PasswordPage(driver)
                .openForgotPasswordPage()
                .clickEnterButton();
        new LoginPage(driver)
                .setEmail(registrationTestData.email)
                .setPassword(registrationTestData.password)
                .clickEnterButton();
        new MainPage(driver)
                .clickPersonalAccountButton();

        boolean isProfileButtonDisplayed = new AccountPage(driver).isProfileButtonDisplayed();
        Assert.assertTrue("Не произошел переход в ЛК: ", isProfileButtonDisplayed);
    }
}
