package praktikum.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordPage {

    private WebDriver driver;

    // Метод перехода на страницу восстановления пароля
    public PasswordPage openForgotPasswordPage() {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        return this;
    }

    // Локатор кнопки Войти
    private By enterButton = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");

    // Конструктор класса
    public PasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод клика по кнопке Войти
    public PasswordPage clickEnterButton() {
        driver.findElement(enterButton).click();
        return this;
    }
}
