package youdo.ui.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import youdo.ui.pages.CompletionOfRegistrationPage;
import youdo.ui.pages.MainPage;
import youdo.ui.pages.RegistrationOrAuthPopUp;
import youdo.ui.pages.ThanksForRegistrationPopUp;

public class RegistrationTests extends TestBase {
    MainPage mp = new MainPage();
    RegistrationOrAuthPopUp regPopUp = new RegistrationOrAuthPopUp();
    CompletionOfRegistrationPage completionReg = new CompletionOfRegistrationPage();
    ThanksForRegistrationPopUp thanksPopUp = new ThanksForRegistrationPopUp();
    Faker faker = new Faker();

    @Test
    void positiveRegistrationTest() {
        String randomEmail = faker.internet().emailAddress(),
                testCityName = "Магнитогорск",
                randomFullName = faker.name().fullName();

        mp.openMainPage()
                .clickRegistrationButton();
        regPopUp.checkNamePopUp()
                .setEmailValue(randomEmail)
                .clickRegistOrAuthButton();
        completionReg.checkTitleRegistrPage()
                .checkEmail(randomEmail)
                .setCityName(testCityName)
                .setFullName(randomFullName)
                .clickSubmit();
        thanksPopUp.checkTitleRegistrPage();
    }

    @Test
    void negativeRegistrationTestWithEmptyEmail() {
        mp.openMainPage()
                .clickRegistrationButton();
        regPopUp.setEmailValue("")
                .clickRegistOrAuthButton()
                .checkErrorEmailMessage();
    }
}
