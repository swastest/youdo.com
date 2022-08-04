package youdo.ui.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import youdo.helpers.DriverUtils;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class LandingTests extends TestBase {

    @Test
    @DisplayName("Проверка соответствия в Title")
    void titleTest() {
        step("Открыть главную страницу", () ->
                open(""));

        step("Title соответствует требованию текста 'YouDo (Юду) – сервис поиска надежных специалистов для выполнения бытовых и фриланс заданий'", () -> {
            String expectedTitle = "YouDo (Юду) – сервис поиска надежных специалистов для выполнения бытовых и фриланс заданий";
            String actualTitle = title();
            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Проверка ошибок в консоли")
    void consoleShouldNotHaveErrorsTest() {
        step("Открыть главную страницу", () ->
                open(""));

        step("Проверка консоли на наличие ошибки 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";
            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}
