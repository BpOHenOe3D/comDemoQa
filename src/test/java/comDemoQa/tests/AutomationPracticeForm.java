package comDemoQa.tests;

import allureAttach.AllureAttach;
import com.codeborne.selenide.Configuration;
import comDemoQa.testData.TestData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class AutomationPracticeForm extends TestData {


    @Test
    @DisplayName("Тест на заполнение формы")
    void fillStandartTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ser");
        $("#lastName").setValue("Nik");
        $("#userEmail").setValue("test@mail.ru");
        $("#userNumber").setValue("1234567890");
        $("[for = gender-radio-1]").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("2010");
        $(".react-datepicker__day--018").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("[for = hobbies-checkbox-2]").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/111.jpg"));
        $("#currentAddress").setValue("Home");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Ser"));
        $(".modal-body").shouldHave(text("Nik"));
        $(".modal-body").shouldHave(text("test@mail.ru"));
        $(".modal-body").shouldHave(text("18 April,2010"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("1234567890"));
        $(".modal-body").shouldHave(text("Maths"));
        $(".modal-body").shouldHave(text("Reading"));
        $(".modal-body").shouldHave(text("Home"));
        $(".modal-body").shouldHave(text("Haryana Karnal"));
        $(".modal-body").shouldHave(text("111.jpg"));

    }


}
