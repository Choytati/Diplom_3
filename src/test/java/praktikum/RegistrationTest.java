package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import praktikum.pom.*;

public class RegistrationTest extends BaseTest {

    private RegistrationTestData registrationTestData;

    @Test
    @DisplayName("Проверка регистрации")
    @Description("Базовый тест проверки регистрации с валидными данными")
    public void checkRegistrationWithValidData() {

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

    @Test
    @DisplayName("Проверка  регистрации")
    @Description("Негативный тест проверки регистрации с неверным паролем пользователя")
    public void checkRegistrationWithInvalidShortPassword() {
        registrationTestData = RegistrationTestDataGenerator.getInvalidDataWithShortPassword();

        boolean isIncorrectPasswordTitleDisplayed =
                new RegistrationPage(driver)
                        .openRegistrationPage()
                        .setName(registrationTestData.name)
                        .setEmail(registrationTestData.email)
                        .setPassword(registrationTestData.password)
                        .clickRegistrationButton()
                        .isIncorrectPasswordTitleDisplayed();

        Assert.assertTrue("Не отображается надпись Некорректный пароль: ", isIncorrectPasswordTitleDisplayed);
    }

}