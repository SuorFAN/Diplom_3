import api.UserApi;
import config.WebDriverEnum;
import io.qameta.allure.junit4.DisplayName;
import model.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import web.pages.ConstructorPage;
import web.pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest {
    LoginPage loginPage;
    ConstructorPage constructorPage;
    User user;
    UserApi userApi;

    @Before
    public void setUp() {
        WebDriver webDriver = WebDriverEnum.CHROME.getDriver();
        loginPage = new LoginPage(webDriver);
        user = new User();
        userApi = new UserApi();
        userApi.createUser(user.toString()).then().statusCode(200);
        loginPage.openPage();
        loginPage.authorization(user.getEmail(), user.getPassword()).checkUrl();
        constructorPage = loginPage.appHeader.clickConstructorButton();
    }

    @Test
    @DisplayName("Переходы к разделу «Булки»")
    public void redirectBunsTab() {
        constructorPage.clickFillingsTab();
        constructorPage.clickBunsTab();
        assertTrue(constructorPage.isSelectedBuns());

    }
    @Test
    @DisplayName("Переходы к разделу «Соусы»")
    public void redirectSaucesTab() {
        constructorPage.clickSaucesTab();
        assertTrue(constructorPage.isSelectedSauces());
    }
    @Test
    @DisplayName("Переходы к разделу «Начинки»")
    public void redirectFillingsTab() {
        constructorPage.clickFillingsTab();
        assertTrue(constructorPage.isSelectedFillings());
    }

    @After
    public void tearDown() {
        userApi.deleteUser(user);
        loginPage.closeDriver();
    }
}
