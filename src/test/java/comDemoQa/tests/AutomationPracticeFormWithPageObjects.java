package comDemoQa.tests;


import comDemoQa.pages.AutomationPracticeForm;
import comDemoQa.testData.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AutomationPracticeFormWithPageObjects extends TestData {
    AutomationPracticeForm automationPracticeForm = new AutomationPracticeForm();


    @Test
    @DisplayName("Тест на заполнение формы с PO")
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

