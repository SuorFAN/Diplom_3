package web.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseComponent {

    WebDriver webDriver;

    public BaseComponent(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void waitElement(By webElement) {
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(webElement));
    }
}
