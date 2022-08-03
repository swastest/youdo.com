package youdo.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;

public class CompletionOfRegistrationPage {

    //locators
    private SelenideElement titleRegistration = $(".registration__title"),
            inputEmail = $("#Email__Field"),
            inputFullName = $("#FullName__Field"),
            inputCityName = $("#CityName__Field"),
            submitRegistrButton = $(".registration_submit"),
            menuItem = $("#ui-id-4");

    //actions
    @Step("Проверка: заголовойк страницы соответствует 'Завершение регистрации'")
    public CompletionOfRegistrationPage checkTitleRegistrPage() {
        titleRegistration.shouldHave(text("Завершение регистрации"));
        return this;
    }

    @Step("Ввести город")
    public CompletionOfRegistrationPage setCityName(String city) {
        inputCityName.val(city);
        menuItem.click();
        return this;
    }

    @Step
    public CompletionOfRegistrationPage setFullName(String fullName) {
        inputFullName.val(fullName);
        return this;
    }

    @Step("Проверка: е-мейл соответствует ранее введенному значению")
    public CompletionOfRegistrationPage checkEmail(String expectEmail) {
        inputEmail.shouldHave(value(expectEmail));
        return this;
    }

    @Step("Нажать кнопку 'Зарегистрироваться'")
    public CompletionOfRegistrationPage clickSubmit() {
        submitRegistrButton.click();
        return this;
    }
}
