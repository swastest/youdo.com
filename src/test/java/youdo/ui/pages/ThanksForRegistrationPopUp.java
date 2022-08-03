package youdo.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ThanksForRegistrationPopUp {
    //locators
    private SelenideElement title = $(".WelcomeModal_title__2RD1t");

    //actions
    @Step("Проверка: заголовок поп-апа соответствует 'Спасибо за регистрацию'")
    public ThanksForRegistrationPopUp checkTitleRegistrPage() {
        title.shouldHave(text("Спасибо за регистрацию"));
        return this;
    }
}
