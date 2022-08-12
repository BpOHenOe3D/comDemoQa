package comDemoQa.tests;

import com.codeborne.selenide.Configuration;

import comDemoQa.pages.AutomationPracticeForm;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AutomationPracticeFormWithPageObjects {
    AutomationPracticeForm automationPracticeForm = new AutomationPracticeForm();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "2560x1440";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillGoodTest (){
        automationPracticeForm.openPage()
                .fillFirstName("Ser")
                .fillLastName("Nik")
                .fillEmailInput("test@mai.ru")
                .fillNumberInput("1234567890")
                .setGender("Male")
                .setBirthDate("13","April","2010")
                .fillSubjectInput("Math")
                .setHobbies("Reading")
                .uploadFile("src/test/resources/111.jpg")
                .fillAdressInput("Home")
                .setStateAndCity("Haryana","Karnal")
                .submitButtonClick();

        automationPracticeForm.checkResultsTableVisible()
                .checkResult("Student Name","Ser Nik")
                .checkResult("Student Email","test@mai.ru")
                .checkResult("Date of Birth","13 April,2010")
                .checkResult("Gender","Male")
                .checkResult("Mobile","1234567890")
                .checkResult("Subjects","Maths")
                .checkResult("Hobbies","Reading")
                .checkResult("Address","Home")
                .checkResult("State and City","Haryana Karnal")
                .checkResult("Picture","111.jpg");
        }

    }

