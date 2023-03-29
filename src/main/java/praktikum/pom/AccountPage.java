package praktikum.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    private WebDriver driver;

    // Локатор кнопки Профиль
    private By profileButton = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[1]/a");

    // Локатор кнопки Конструктор
    private By constructorButton = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p");

    // Локатор логотипа Stellar Burgers
    private By logoStellarBurgers = By.xpath("//*[@id=\"root\"]/div/header/nav/div");

    // Локатор кнопки Выход
    private By logoutButton = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button");

    // Конструктор класса
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод проверки отображения указателя Профиль
    public boolean isProfileButtonDisplayed() {
        return driver.findElement(profileButton).isDisplayed();
    }

    // Метод клика по кнопке Конструктор
    public AccountPage clickConstructorButton() {
        driver.findElement(constructorButton).click();
        return this;
    }

    // Метод клика по логотипу Stellar Burgers
    public AccountPage clickLogoStellarBurgers() {
        driver.findElement(logoStellarBurgers).click();
        return this;
    }

    // Метод клика по кнопке Выход
    public AccountPage clickLogoutButton () {
        driver.findElement(logoutButton ).click();
        return this;
    }
}