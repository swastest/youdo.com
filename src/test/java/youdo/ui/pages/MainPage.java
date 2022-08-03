package youdo.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    //locators
    private SelenideElement loginButton = $(".AnonymousLogin_link__1pGSj", 0),
    registrationButton = $(".AnonymousLogin_link__1pGSj", 1),
    taskButton = $("href='/tasks/new'");

    //actions
    @Step("Открыть страницу авторизации")
    public MainPage openMainPage() {
        open("");
        return this;
    }
    @Step("Нажать на кнопку 'регистрация'")
    public  MainPage clickRegistrationButton(){
        registrationButton.click();
        return this;
    }

    @Step("Нажать на кнопку 'Вход'")
    public MainPage clickLoginButton(){
        loginButton.click();
        return this;
    }


}
