package demoqa.pages;

import demoqa.pages.components.CalendarComponent;
import demoqa.pages.components.ResultsModalComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class RegistrationFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsModalComponent resultsModalComponent = new ResultsModalComponent();

    private final static String TITLE_TEXT = "Student Registration Form";


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        $("#firstName").setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        $("#lastName").setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubjects(String value) {
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobby(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage uploadFile(String value) {
        $("#uploadPicture").uploadFile(new File(value));

        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);

        return this;
    }

    public RegistrationFormPage setState(String value) {
        $("#react-select-3-input").setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage setCity(String value) {
        $("#react-select-4-input").setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage pressSubmit() {
        $("#submit").scrollTo().pressEnter();

        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultsModalComponent.checkVisible();

        return this;
    }

    public RegistrationFormPage checkResults(String key, String value) {
        resultsModalComponent.checkResult(key, value);

        return this;
    }
}
