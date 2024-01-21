package web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Страница <a href="https://stellarburgers.nomoreparties.site/forgot-password">восстановления пароля</a>
 * Использует компонент @see web.pages.components.AppHeader
 */
public class ForgotPasswordPage extends BasePage {

    private final By loginButton = By.xpath("//a[@href='/login']");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver, "https://stellarburgers.nomoreparties.site/forgot-password");
    }

    @Step("Нажать на кнопку войти")
    public LoginPage clickLoginButton() {
        waitElement(loginButton);
        driver.findElement(loginButton).click();
        return new LoginPage(this.driver);
    }
}
