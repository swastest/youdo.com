package youdo.ui.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import youdo.ui.pages.MainPage;
import youdo.ui.pages.ProfilePage;
import youdo.ui.pages.RegistrationOrAuthPopUp;

import static youdo.config.ConfigCenter.configTestData;

@Tag("auth")
public class AuthTests extends TestBase {
    MainPage mp = new MainPage();
    RegistrationOrAuthPopUp regPopUp = new RegistrationOrAuthPopUp();
    ProfilePage profile = new ProfilePage();
    Faker faker = new Faker();
    String loginEmail = configTestData.loginEmail(),
            password = configTestData.password(),
            fakePassword = faker.numerify("#############");

    @Test
    @DisplayName("Позитивная проверка авторизации")
    void positiveAuthTest() {
        mp.openMainPage()
                .clickLoginButton();
        regPopUp.setEmailValueAndPressEnter(loginEmail)
                .setPassword(password)
                .clickRegistOrAuthButton();
        profile.clickIconProfile()
                .clickProfileTab()
                .checkAuthEmail(loginEmail);
    }

    @Test
    @DisplayName("Негативная проверка логина(пользователь не указал login)")
    void negativeTestWithoutLogin() {
        mp.openMainPage()
                .clickLoginButton();
        regPopUp.clickRegistOrAuthButton()
                .checkErrorEmailMessage();
    }

    @Test
    @DisplayName("Негативная проверка логина(неправильная пара логин/пароль)")
    void negativeTestWithoutWrongPassword() {
        mp.openMainPage()
                .clickLoginButton();
        regPopUp.setEmailValueAndPressEnter(loginEmail)
                .setPassword(fakePassword)
                .clickRegistOrAuthButton()
                .checkErrorLoginMessage();
    }
}
