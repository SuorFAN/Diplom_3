package web.pages.components;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.pages.ConstructorPage;
import web.pages.ProfilePage;

/**
 * Компонент AppHeader страниц
 */
public class AppHeader extends BaseComponent {

    private final By constructorButton = By.xpath(".//a[@href='/' and contains(@class, 'AppHeader_header')]");
    private final By stellarBurgerButton = By.xpath(".//div/header/nav/div[contains(@class, 'AppHeader_header')]");
    private final By profileButton = By.xpath("//p[text()='Личный Кабинет']");

    public AppHeader(WebDriver webDriver) {
        super(webDriver);
    }


    @Step("Нажать на кнопку Конструктор")
    public ConstructorPage clickConstructorButton() {
        waitElement(constructorButton);
        webDriver.findElement(constructorButton).click();
        return new ConstructorPage(this.webDriver);
    }

    @Step("Нажать на кнопку StellarBurger")
    public ConstructorPage clickStellarBurgerButton() {
        waitElement(constructorButton);
        webDriver.findElement(stellarBurgerButton).click();
        return new ConstructorPage(this.webDriver);
    }

    @Step("Нажать на кнопку Личный кабинет")
    public ProfilePage clickProfileButton() {
        waitElement(profileButton);
        webDriver.findElement(profileButton).click();
        return new ProfilePage(this.webDriver);
    }
}
