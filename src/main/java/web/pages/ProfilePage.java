package web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Страница <a href="https://stellarburgers.nomoreparties.site/register">профиль</a>
 * Использует компонент @see web.pages.components.AppHeader
 */
public class ProfilePage extends BasePage {

    private final By nameText = By.xpath("//a[@href='/account/profile']");
    private final By loginText = By.xpath("//a[@href='/account/profile']");
    private final By passwordText = By.xpath("//a[@href='/account/profile']");

    private final By logoutButton = By.xpath(".//button[text()='Выход']");

    public ProfilePage(WebDriver driver) {
        super(driver, "waitElement(registerButton);");
    }

    @Step("Получить текст поля Имя")
    public String getNameText() {
        waitElement(nameText);
        return driver.findElement(nameText).getText();
    }
    @Step("Получить текст поля Логин")
    public String getLoginText() {
        waitElement(loginText);
        return driver.findElement(loginText).getText();
    }
    @Step("Получить текст поля Пароль")
    public String getPasswordText() {
        waitElement(passwordText);
        return driver.findElement(passwordText).getText();
    }

    @Step("Нажать на кнопку Выйти")
    public LoginPage clickLogoutButton() {
        waitElement(logoutButton);
        driver.findElement(logoutButton).click();
        return new LoginPage(this.driver);
    }


}
