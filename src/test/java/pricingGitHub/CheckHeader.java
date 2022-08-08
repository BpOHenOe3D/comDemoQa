package pricingGitHub;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckHeader {

    @BeforeAll

    static void configure() {
        Configuration.browserSize = "2560x1440";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void check(){
        open("https://github.com/");
        $(".HeaderMenu--logged-out").$(byText("Pricing")).hover();
        $(byText("Compare plans")).click();
        $(".font-mktg").shouldHave(text("Choose the plan that’s right for you.")).scrollTo();
    }
}
