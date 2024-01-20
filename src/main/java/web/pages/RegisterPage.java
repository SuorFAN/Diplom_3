package web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Страница <a href="https://stellarburgers.nomoreparties.site/register">регистрации</a>
 * Использует компонент @see web.pages.components.AppHeader
 */
public class RegisterPage extends BasePage {

    private final By nameText = By.xpath("//fieldset[1]/div/div/input[@type='text']");
    private final By emailText = By.xpath("//fieldset[2]/div/div/input[@type='text']");
    private final By passwordText = By.xpath(".//input[@type='password']");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By loginButton = By.xpath("//a[@href='/login']");

    public RegisterPage(WebDriver driver) {
        super(driver, "https://stellarburgers.nomoreparties.site/register");
    }

    @Step("Задать значение полю Имя = {0}")
    public RegisterPage setNameText(String value) {
        waitElement(nameText);
        driver.findElement(nameText).click();
        driver.findElement(nameText).clear();
        driver.findElement(nameText).sendKeys(value);
        return this;
    }

    @Step("Задать значение полю Email = {0}")
    public RegisterPage setEmailText(String value) {
        waitElement(emailText);
        driver.findElement(emailText).click();
        driver.findElement(emailText).clear();
        driver.findElement(emailText).sendKeys(value);
        return this;
    }

    @Step("Задать значение полю Пароль = {0}")
    public RegisterPage setPasswordText(String value) {
        waitElement(passwordText);
        driver.findElement(passwordText).click();
        driver.findElement(passwordText).clear();
        driver.findElement(passwordText).sendKeys(value);
        return this;
    }

    @Step("Нажать на кнопку Зарегистрироваться")
    public LoginPage clickRegisterButton() {
        waitElement(registerButton);
        driver.findElement(registerButton).click();
        return new LoginPage(this.driver);
    }

    @Step("Нажать на кнопку Войти")
    public LoginPage clickLoginButton() {
        waitElement(loginButton);
        driver.findElement(loginButton).click();
        return new LoginPage(this.driver);
    }

    @Step("Зарегестрировать клиента: Имя = {0}; Email = {0}; Пароль = {0}")
    public LoginPage registration(String nameValue, String emailValue, String passwordValue) {
        setNameText(nameValue);
        setEmailText(emailValue);
        setPasswordText(passwordValue);
        return clickRegisterButton();
    }


}
