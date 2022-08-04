package selenideGitHub;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchJU5 {
    @BeforeAll

    static void configure() {
        Configuration.browserSize = "2560x1440";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void search() {
        // Ищем репозиторий Селенида
        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        // Проверяем наличие SoftAssertions в Вики Селенида и наличие примера кода JU5
        $("#wiki-tab").click();
        $(".js-wiki-more-pages-link").click();
        $(".Box--condensed").shouldHave(text("SoftAssertions"));
        $(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("3. Using JUnit5 extend test class"));
    }
}
