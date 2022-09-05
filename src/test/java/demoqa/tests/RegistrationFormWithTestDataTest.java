package demoqa.tests;

import demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class RegistrationFormWithTestDataTest extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void fillFormTest () {
        step("Open registration form", () -> {
            registrationFormPage.openPage();
        });

        step("Fill registration form", () -> {
            registrationFormPage.setFirstName(TestData.firstName)
                .setLastName(TestData.lastName)
                .setEmail(TestData.email)
                .setGender(TestData.gender)
                .setNumber(TestData.mobileNumber)
                .setBirthDate(TestData.day, TestData.month, TestData.year)
                .setSubjects(TestData.subjects)
                .setHobby(TestData.hobby_1)
                .setHobby(TestData.hobby_2)
                .setHobby(TestData.hobby_3)
                .uploadFile(TestData.filePathResources + TestData.fileName)
                .setCurrentAddress(TestData.currentAddress)
                .setState(TestData.state)
                .setCity(TestData.city)
                .pressSubmit();
        });

        step("Check registration form results", () -> {
            String expectedFullName = String.format("%s %s", TestData.firstName, TestData.lastName);
            String expectedDateOfBirth = String.format("%s %s,%s", TestData.day, TestData.month, TestData.year);
            String expectedHobby = String.format("%s, %s, %s", TestData.hobby_1, TestData.hobby_2, TestData.hobby_3);
            String expectedStateAndCity = String.format("%s %s", TestData.state, TestData.city);

            registrationFormPage.checkResultsTableVisible()
                .checkResults("Student Name", expectedFullName)
                .checkResults("Student Email", TestData.email)
                .checkResults("Gender", TestData.gender)
                .checkResults("Mobile", TestData.mobileNumber)
                .checkResults("Date of Birth", expectedDateOfBirth)
                .checkResults("Subjects", TestData.subjects)
                .checkResults("Hobbies", expectedHobby)
                .checkResults("Picture", TestData.fileName)
                .checkResults("Address", TestData.currentAddress)
                .checkResults("State and City", expectedStateAndCity);
        });
    }
}
