import api.UserApi;
import config.WebDriverEnum;
import io.qameta.allure.junit4.DisplayName;
import model.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import web.pages.*;

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
        loginPage.appHeader.clickProfileButton().getLoginText();
    }


    @Test
    @DisplayName("Переход по клику на «Конструктор» и на логотип Stellar Burgers.")
    public void redirectFromProfileToConstructor() {
        loginPage.appHeader.clickProfileButton()
                .appHeader.clickConstructorButton()
                .appHeader.clickStellarBurgerButton();
    }

    @After
    public void tearDown() {
        userApi.deleteUser(user);
        registerPage.closeDriver();
    }
}
