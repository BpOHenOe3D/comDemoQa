package allureTests;

import com.codeborne.selenide.Condition;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class StepsTest {
    private static final String REPOSITORY = "comDemoQa";

    @Test
    @Disabled
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу", () -> {
            open("https://github.com");
        });
        step("Найти репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Кликнуть по ссылке репозитория" + REPOSITORY, () -> {
            $("a[href*='BpOHenOe3D/comDemoQa']").click();
        });
        step("Найти раздел Issues", () -> {
            $(withText("Issue")).should(Condition.exist);
        });
    }

    @Test
    @Disabled
    public void testAnnotatedStepAttachment() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebTest steps = new WebTest();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.seachIssuesTab();
        steps.takeScreenshot();

    }
}
