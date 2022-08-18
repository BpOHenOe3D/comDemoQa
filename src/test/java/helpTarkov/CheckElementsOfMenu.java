package helpTarkov;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CheckElementsOfMenu {

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "2560x1440";
        Configuration.holdBrowserOpen = true;
    }


    static Stream<Arguments> checkMenu() {
        return Stream.of(
                Arguments.of("Карты, ключи, выходы", List.of("Берег Завод Лаборатория Лес Развязка Резерв Таможня Маяк Контейнеры")),
                Arguments.of("Квесты", List.of("Прапор Терапевт Скупщик Лыжник Миротворец Механик Барахольщик Егерь"))
        );
    }
    @MethodSource
    @ParameterizedTest(name = "Меню  \"{0}\" содержит элементы: \"{1}\"")
    void checkMenu(String lang, List<String> expectedElementsOfMenu) {
        open("https://tarkov.help/ru/");
        $(".second_row").$(byText(lang)).hover();
        $$(".third_row").shouldHave(CollectionCondition.texts(expectedElementsOfMenu));

    }

    @CsvSource(value = {
            "Карты, ключи, выходы|  Берег Завод Лаборатория Лес Развязка Резерв Таможня Маяк Контейнеры",
            "Квесты|  Прапор Терапевт Скупщик Лыжник Миротворец Механик Барахольщик Егерь",
    },delimiter = '|')
    @ParameterizedTest(name = "Меню  \"{0}\" содержит элементы: \"{1}\"")
    void commonCheckElementsMenuTest(String testData, String expectedResult) {
        open("https://tarkov.help/ru/");
        $(".second_row").$(byText(testData)).hover();
        $$(".third_row").shouldHave(CollectionCondition.texts(expectedResult));
    }

    @EnumSource(Menu.class)
    @ParameterizedTest
    void tarkovMenuElements(Menu lang){
        open("https://tarkov.help/ru/");
        $(".second_row").$(byText(lang.getElements())).hover();
        $(".third_row").shouldBe(Condition.visible);
    }

}