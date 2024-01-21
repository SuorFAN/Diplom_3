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


    private final By bunsTab = By.xpath(".//div/main/section[1]/div[1]/div[1]");
    private final By saucesTab = By.xpath(".//div/main/section[1]/div[1]/div[2]");
    private final By fillingsTab = By.xpath(".//div/main/section[1]/div[1]/div[3]");


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
        clickTabs(bunsTab);
        return this;
    }


    @Step("Нажать на вкладку Начинки")
    public ConstructorPage clickFillingsTab() {
        clickTabs(fillingsTab);
        return this;
    }

    @Step("Нажать на вкладку Соусы")
    public ConstructorPage clickSaucesTab() {
        clickTabs(saucesTab);
        return this;
    }

    private void clickTabs(By tab){
        waitElement(tab);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(tab));
        driver.findElement(tab).click();
    }

    @Step("Проверка успешного входа")
    public boolean checkLogin() {
        return driver.findElements(loginButton).isEmpty();
    }

    @Step("Проверить что вкладка Булки выбрана")
    public boolean isSelectedBuns(){
        return driver.findElement(bunsTab).getAttribute("class").equals("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect");
    }
    @Step("Проверить что вкладка Булки выбрана")
    public boolean isSelectedSauces(){
        return driver.findElement(saucesTab).getAttribute("class").equals("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect");
    }
    @Step("Проверить что вкладка Булки выбрана")
    public boolean isSelectedFillings(){
        return driver.findElement(fillingsTab).getAttribute("class").equals("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect");
    }
}
