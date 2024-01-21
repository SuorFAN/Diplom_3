package web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Страница <a href="https://stellarburgers.nomoreparties.site/login">регистрации</a>
 * Использует компонент @see web.pages.components.AppHeader
 */
public class LoginPage extends BasePage {

    private final By emailText = By.xpath(".//input[@type='text']");
    private final By passwordText = By.xpath(".//input[@type='password']");
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    private final By registerButton = By.xpath("//a[@href='/register']");
    private final By forgotPasswordButton = By.xpath("//a[@href='/forgot-password']");


    public LoginPage(WebDriver driver) {
        super(driver, "https://stellarburgers.nomoreparties.site/login");
    }

    @Step("Заполнить значением поле Email = {0}")
    public LoginPage setEmailText(String text) {
        waitElement(emailText);
        driver.findElement(emailText).click();
        driver.findElement(emailText).clear();
        driver.findElement(emailText).sendKeys(text);
        return this;
    }

    @Step("Заполнили Пароль = {0}")
    public LoginPage setPasswordText(String text) {
        waitElement(passwordText);
        driver.findElement(passwordText).click();
        driver.findElement(passwordText).clear();
        driver.findElement(passwordText).sendKeys(text);
        return this;
    }

    @Step("Авторизоваться в системе данными : поле Email = {0}; Пароль = {0}.")
    public ConstructorPage authorization(String emailValue, String passwordValue) {
        setEmailText(emailValue);
        setPasswordText(passwordValue);
        return clickLoginButton();
    }

    @Step("Нажать на кнопку войти")
    public ConstructorPage clickLoginButton() {
        waitElement(loginButton);
        driver.findElement(loginButton).click();
        return new ConstructorPage(this.driver);
    }

    @Step("Нажать на кнопку Зарегистрироваться")
    public RegisterPage clickRegisterButton() {
        waitElement(registerButton);
        driver.findElement(registerButton).click();
        return new RegisterPage(this.driver);
    }

    @Step("Нажать на кнопку Восстановить пароль")
    public ForgotPasswordPage clickForgotPasswordButton() {
        waitElement(forgotPasswordButton);
        driver.findElement(forgotPasswordButton).click();
        return new ForgotPasswordPage(this.driver);
    }
}
