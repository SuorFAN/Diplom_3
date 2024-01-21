import api.UserApi;
import config.WebDriverEnum;
import model.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import web.pages.LoginPage;
import web.pages.RegisterPage;

/**
 * Класс для проверки регистрации пользователя
 */
public class RegisterTest {
    RegisterPage registerPage;
    User user;
    UserApi userApi;

    @Before
    public void setUp() {
        registerPage = new RegisterPage(WebDriverEnum.CHROME.getDriver());
        user = new User();
        userApi = new UserApi();
    }

    @Test
    public void successRegister() {
        registerPage.openPage();
        LoginPage loginPage = registerPage.registration(user.getName(), user.getEmail(), user.getPassword());
        loginPage.clickLoginButton();
        loginPage.checkUrl();
    }

    @Test
    public void failureRegister() {
        registerPage.openPage();
        registerPage.registration(user.getName(), "", user.getPassword());
        registerPage.checkUrl();
    }

    @After
    public void tearDown() {
        userApi.deleteUser(user);
        registerPage.closeDriver();
    }
}
