package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.pages.components.ResultsModal;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormWithPageObjectsUtilsTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    ResultsModal resultsModal = new ResultsModal();


    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender("Other")
                .setNumber(phone)
                .setBirthDate(generateDay(), generateMonth(), generateYear())
                .setSubjectInput()
                .setHobbiesWrapper()
                .uploadPicture()
                .setCurrentAddress()
                .setState()
                .setCity();
        registrationFormPage.clickSubmit();
        resultsModal.checkVisible();
        registrationFormPage.checkResultsTableVisible()
                    .checkResult("Student Name", firstName)
                    .checkResult("Student Email", email)
                    .checkResult("Date of Birth", generateDay() + " " + generateMonth() + "," + generateYear());
        resultsModal.checkVisible();
        System.out.println("okk");
    }
}
