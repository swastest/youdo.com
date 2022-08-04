package youdo.ui.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import youdo.ui.pages.CompletionOfRegistrationPage;
import youdo.ui.pages.MainPage;
import youdo.ui.pages.RegistrationOrAuthPopUp;
import youdo.ui.pages.ThanksForRegistrationPopUp;

@Tag("reg")
public class RegistrationTests extends TestBase {
    MainPage mp = new MainPage();
    RegistrationOrAuthPopUp regPopUp = new RegistrationOrAuthPopUp();
    CompletionOfRegistrationPage completionReg = new CompletionOfRegistrationPage();
    ThanksForRegistrationPopUp thanksPopUp = new ThanksForRegistrationPopUp();
    Faker faker = new Faker();

    @Test
    @DisplayName("Позитивная проверка регистрации, с валидными данными")
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
    @DisplayName("Негативная проверка регистрации (пользователь указал невалидный e-mail)")
    void negativeRegistrationTestWithInvalidEmail() {
        String invalidEmail = faker.aviation().aircraft();
        mp.openMainPage()
                .clickRegistrationButton();
        regPopUp.setEmailValue(invalidEmail)
                .clickRegistOrAuthButton()
                .checkErrorEmailMessage();
    }
}
