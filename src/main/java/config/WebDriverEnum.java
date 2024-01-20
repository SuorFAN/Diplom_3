package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public enum WebDriverEnum {
    CHROME("ChromeDriver"),
    YANDEX("Yandex");
    private final String driver;
    private final String yandexDriver = "C:\\Users\\gfhjd\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\yandexdriver.exe";
    private final String yandexBrowser = "C:\\Users\\gfhjd\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";

    WebDriverEnum(String driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        if (driver.equals("ChromeDriver")) {
            return new ChromeDriver(options);
        } else if (driver.equals("Yandex")) {
            System.setProperty("webdriver.chrome.driver", yandexDriver);
            options.setBinary(yandexBrowser);
            return new ChromeDriver(options);
        }
        return new FirefoxDriver();
    }
}
