package youdo.ui.tests;

import org.junit.jupiter.api.Test;
import youdo.ui.pages.MainPage;
import youdo.ui.pages.ProfilePage;
import youdo.ui.pages.RegistrationOrAuthPopUp;

import static youdo.config.ConfigCenter.configTestData;

public class AuthTests extends TestBase {
    MainPage mp = new MainPage();
    RegistrationOrAuthPopUp regPopUp = new RegistrationOrAuthPopUp();
    ProfilePage profile = new ProfilePage();

    @Test
    void positiveAuthTest() {
        String loginEmail = configTestData.loginEmail(),
                password = configTestData.password();
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
    void negativeTestWithoutLogin(){

    }
}
