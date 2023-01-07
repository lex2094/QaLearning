package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjectsMinTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    @Test
    void fillFormWithMinimumDataTest() {
        registrationFormPage.openPage()
                .setFirstName("Alexey")
                .setLastName("Cherepanov")
                .setGender("Other")
                .setNumber("1234567890")
                .setBirthDate("15","September","1995")
                .clickSubmit();
        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Alexey Cherepanov")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "15 September,1995");
    }
}
