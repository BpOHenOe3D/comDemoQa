package comDemoQa.tests;

import com.codeborne.selenide.Configuration;

import comDemoQa.pages.AutomationPracticeForm;
import comDemoQa.testData.TestData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AutomationPracticeFormWithPageObjects extends TestData {
    AutomationPracticeForm automationPracticeForm = new AutomationPracticeForm();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "2560x1440";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillGoodTest() {
        automationPracticeForm.openPage()
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillEmailInput(userEmail)
                .fillNumberInput(userNumber)
                .setGender(gender)
                .setBirthDate(day, month, year)
                .fillSubjectInput(subject)
                .setHobbies(hobbie)
                .uploadFile(picture)
                .fillAdressInput(adress)
                .setStateAndCity(state, city)
                .submitButtonClick();

        automationPracticeForm.checkResultsTableVisible()
                .checkResult("Student Name", fullName)
                .checkResult("Student Email", userEmail)
                .checkResult("Date of Birth", dateOfBirth)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbie)
                .checkResult("Address", adress)
                .checkResult("State and City", stateAndCity)
                .checkResult("Picture", checkPicture);
    }

}

