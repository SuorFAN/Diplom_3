import api.UserApi;
import config.WebDriverEnum;
import io.qameta.allure.junit4.DisplayName;
import model.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import web.pages.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RedirectTest {
    LoginPage loginPage;
    ConstructorPage constructorPage;
    RegisterPage registerPage;
    ProfilePage profilePage;

    User user;
    UserApi userApi;

    @Before
    public void setUp() {
        WebDriver webDriver = WebDriverEnum.CHROME.getDriver();
        constructorPage = new ConstructorPage(webDriver);
        loginPage = new LoginPage(webDriver);
        registerPage = new RegisterPage(webDriver);
        profilePage = new ProfilePage(webDriver);
        user = new User();
        userApi = new UserApi();
        userApi.createUser(user.toString()).then().statusCode(200);
        loginPage.openPage();
        loginPage.authorization(user.getEmail(), user.getPassword()).checkUrl();
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет».")
    public void redirectByClickProfile() {
        assertEquals(user.getEmail(),loginPage.appHeader.clickProfileButton().getLoginText());
    }


    @Test
    @DisplayName("Переход по клику на «Конструктор»")
    public void redirectFromProfileToConstructor() {
        assertTrue(loginPage.appHeader.clickProfileButton().appHeader.clickConstructorButton().checkUrl());
    }

    @Test
    @DisplayName("Переход по клику на логотип Stellar Burgers.")
    public void redirectFromProfileStellarBurger() {
        assertTrue(loginPage.appHeader.clickProfileButton().appHeader.clickStellarBurgerButton().checkUrl());
    }

    @After
    public void tearDown() {
        userApi.deleteUser(user);
        registerPage.closeDriver();
    }
}
