package youdo.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationOrAuthPopUp {
    //locators
    private SelenideElement registrTitle = $(".SignInModal_socialTitle__1H72B"),
            emailInput = $(".AuthorizationTabs_container__3cmzU").$(".Input_input__WvGSe", 0),
            passwordInput = $(".AuthorizationTabs_container__3cmzU").$(".Input_input__WvGSe", 1),
            registrAuthButton = $(".AuthorizationTabs_container__3cmzU").$(".NewButton_button__32hCB"),
            registrTub = $(".Tabs_item__2qscM", 0),
            authTub = $(".Tabs_item__2qscM", 1),
            registrNaimPopUp = $(".SignInModal_socialTitle__1H72B"),
            errorMessageElement = $(".Tooltip_tooltip__2kgez ");

    //actions
    @Step("Ввести e-mail")
    public RegistrationOrAuthPopUp setEmailValue(String mail) {
        emailInput.val(mail);
        return this;
    }

    @Step("Ввести e-mail")
    public RegistrationOrAuthPopUp setEmailValueAndPressEnter (String mail) {
        emailInput.val(mail).pressEnter();
        return this;
    }

    @Step("Наименование поп-апа соответствует'Быстрая регистрация через:'")
    public RegistrationOrAuthPopUp checkNamePopUp() {
        registrNaimPopUp.shouldHave(text("Быстрая регистрация через:"));
        return this;
    }

    @Step("Нажать кнопку 'Зарегистрироваться/Далее'")
    public RegistrationOrAuthPopUp clickRegistOrAuthButton() {
        registrAuthButton.click();
        return this;
    }

    @Step("Проверка: сообщение о некорректном e-mail соответствует тексту 'Неправильный Email адрес'")
    public RegistrationOrAuthPopUp checkErrorEmailMessage() {
        errorMessageElement.shouldHave(text("Неправильный Email адрес"));
        return this;
    }

    @Step("Ввести пароль")
    public RegistrationOrAuthPopUp setPassword(String pass) {
        passwordInput.val(pass);
        return this;
    }
}
