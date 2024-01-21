import api.UserApi;
import config.WebDriverEnum;
import io.qameta.allure.junit4.DisplayName;
import model.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import web.pages.LoginPage;


public class LogoutTest {
    LoginPage loginPage;

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
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginFromConstructorPage() {
        loginPage.openPage();
        loginPage.appHeader.clickProfileButton().clickLogoutButton().clickLoginButton();
    }

    @After
    public void tearDown() {
        userApi.deleteUser(user);
        loginPage.closeDriver();
    }
}
