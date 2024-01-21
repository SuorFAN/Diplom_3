package web.pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.pages.components.AppHeader;

import java.time.Duration;


/**
 * Базовый класс для страниц
 */
public abstract class BasePage {
    String url;
    WebDriver driver;

    public AppHeader appHeader;

    protected BasePage(WebDriver driver, String url) {
        this.url = url;
        this.driver = driver;
        this.appHeader = new AppHeader(driver);
    }

    public void openPage() {
        driver.get(url);
        checkUrl();
    }

    @Step("Проверка url")
    public boolean checkUrl() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(url));
        return url.equals(driver.getCurrentUrl());
    }

    @Step("Проверка url")
    public void checkUrl(String url) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(url));
    }

    @Step("Закрыть браузер")
    public void closeDriver() {
        driver.close();
    }

    public void waitElement(By webElement) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(webElement));
    }
}
