import api.UserApi;
import config.WebDriverEnum;
import io.qameta.allure.junit4.DisplayName;
import model.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import web.pages.ConstructorPage;
import web.pages.ForgotPasswordPage;
import web.pages.LoginPage;
import web.pages.RegisterPage;

public class LoginTest {

    LoginPage loginPage;
    ConstructorPage constructorPage;
    RegisterPage registerPage;
    ForgotPasswordPage forgotPasswordPage;

    User user;
    UserApi userApi;

    @Before
    public void setUp() {
        WebDriver webDriver = WebDriverEnum.CHROME.getDriver();
        constructorPage = new ConstructorPage(webDriver);
        loginPage = new LoginPage(webDriver);
        registerPage = new RegisterPage(webDriver);
        forgotPasswordPage = new ForgotPasswordPage(webDriver);
        user = new User();
        userApi = new UserApi();
        userApi.createUser(user.toString()).then().statusCode(200);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginFromConstructorPage() {
        constructorPage.openPage();
        constructorPage.clickLoginButton()
                .authorization(user.getEmail(), user.getPassword())
                .clickOrderButton();
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginFromAccount() {
        constructorPage.openPage();
        constructorPage.appHeader.clickProfileButton();
        loginPage.authorization(user.getEmail(), user.getPassword())
                .clickOrderButton();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginFromRegistration() {
        registerPage.openPage();
        registerPage.clickLoginButton()
                .authorization(user.getEmail(), user.getPassword())
                .clickOrderButton();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginFromForgotPassword() {
        forgotPasswordPage.openPage();
        forgotPasswordPage.clickLoginButton()
                .authorization(user.getEmail(), user.getPassword())
                .clickOrderButton();
    }

    @After
    public void tearDown() {
        userApi.deleteUser(user);
        loginPage.closeDriver();
    }
}