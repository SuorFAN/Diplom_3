package web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Страница <a href="https://stellarburgers.nomoreparties.site/">конструктора</a>
 * Использует компонент @see web.pages.components.AppHeader
 */
public class ConstructorPage extends BasePage {

    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By orderButton = By.xpath(".//button[text()='Оформить заказ']");


    private final By bunsTab = By.xpath(".//span[text()='Булки']");
    private final By bunsList = By.xpath(".//h2[text()='Булки']/..");

    private final By saucesTab = By.xpath(".//span[text()='Соусы']");
    private final By saucesList = By.xpath(".//h2[text()='Соусы']/..");

    private final By fillingsTab = By.xpath(".//span[text()='Начинки']");
    private final By fillingsList = By.xpath(".//h2[text()='Начинки']/..");


    public ConstructorPage(WebDriver driver) {
        super(driver, "https://stellarburgers.nomoreparties.site/");
    }


    @Step("Нажать на кнопку Войти в аккаунт")
    public LoginPage clickLoginButton() {
        waitElement(loginButton);
        driver.findElement(loginButton).click();
        return new LoginPage(this.driver);
    }

    @Step("Нажать на кнопку Оформить заказ")
    public ConstructorPage clickOrderButton() {
        waitElement(orderButton);
        driver.findElement(orderButton).click();
        return this;
    }

    @Step("Нажать на вкладку Булки")
    public ConstructorPage clickBunsTab() {
        waitElement(bunsTab);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(bunsTab));
        driver.findElement(bunsTab).click();
        waitElement(bunsTab);
        driver.findElement(bunsList).isDisplayed();
        return this;
    }


    @Step("Нажать на вкладку Начинки")
    public ConstructorPage clickFillingsTab() {
        waitElement(fillingsTab);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(fillingsTab));
        driver.findElement(fillingsTab).click();
        waitElement(fillingsList);
        driver.findElement(fillingsList).isDisplayed();
        return this;
    }

    @Step("Нажать на вкладку Соусы")
    public ConstructorPage clickSaucesTab() {
        waitElement(saucesTab);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(saucesTab));
        driver.findElement(saucesTab).click();
        waitElement(saucesList);
        driver.findElement(saucesList).isDisplayed();
        return this;
    }
}
