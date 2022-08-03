package youdo.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProfilePage {
    //locators
    private SelenideElement iconProfile = $(".avatar_block__3byw6"),
    menuProfile = $$("ul.ProfileDropDownMenu_items__3Pbau").first(),
    contactEmail = $(".i-verified").$(".b-profile-contact__adv");

    //actions
    @Step("Проверка: e-mail профиля принадлежит авторизированному пользователю")
    public ProfilePage checkAuthEmail(String email){
        contactEmail.shouldHave(Condition.text(email));
        return this;
    }

    @Step("Нажать на иконку Профиля")
    public ProfilePage clickIconProfile(){
        iconProfile.click();
        return this;
    }

    @Step("Выбрать, в выпадающем меню вкладку 'Профиль'")
    public ProfilePage clickProfileTab(){
        menuProfile.click();
        return this;
    }
}
