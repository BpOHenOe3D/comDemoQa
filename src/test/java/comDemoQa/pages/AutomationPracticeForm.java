package comDemoQa.pages;

import com.codeborne.selenide.SelenideElement;
import comDemoQa.components.CalendarComponent;
import comDemoQa.components.ModalWithResult;
import comDemoQa.components.StateCityComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeForm {

    private final static String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ModalWithResult resultsModal = new ModalWithResult();
    private StateCityComponent stateCityComponent = new StateCityComponent();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            adressInput = $("#currentAddress"),
            submitButton = $("#submit");


    public AutomationPracticeForm openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        return this;
    }

    public AutomationPracticeForm fillFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public AutomationPracticeForm fillLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public AutomationPracticeForm fillEmailInput(String value) {
        emailInput.setValue(value);
        return this;
    }

    public AutomationPracticeForm fillNumberInput(String value) {
        numberInput.setValue(value);
        return this;
    }


    public AutomationPracticeForm setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public AutomationPracticeForm setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }


    public AutomationPracticeForm fillSubjectInput(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public AutomationPracticeForm setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    public AutomationPracticeForm uploadFile(String value) {
        $("#uploadPicture").uploadFile(new File(value));
        return this;
    }

    public AutomationPracticeForm fillAdressInput(String value) {
        adressInput.setValue(value);
        return this;
    }

    public AutomationPracticeForm setStateAndCity(String state, String city) {
        stateCityComponent.setStateAndCity(state, city);
        return this;
    }

    public AutomationPracticeForm submitButtonClick() {
        submitButton.click();
        return this;
    }

    public AutomationPracticeForm checkResultsTableVisible() {
        resultsModal.checkVisible();

        return this;
    }

    public AutomationPracticeForm checkResult(String key, String value) {
        resultsModal.checkResult(key, value);
        return this;

    }


}
