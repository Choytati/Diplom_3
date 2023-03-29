package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import praktikum.pom.*;

public class LogoutTest extends BaseTest {
    private RegistrationTestData registrationTestData;

    @Test
    @DisplayName("Проверка выхода из учетной записи")
    @Description("Базовый тест для выхода со страницы учетной записи")
    public void checkLogout() {

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
                .clickLogoutButton();

        boolean isEnterTitleDisplayed = new LoginPage(driver).isEnterTitleDisplayed();
        Assert.assertTrue("Выход не произошел: ", isEnterTitleDisplayed);
    }
}
