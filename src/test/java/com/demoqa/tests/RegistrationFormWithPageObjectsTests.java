package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormWithPageObjectsTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();


    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setEmail("alex@egorov.com")
                .setGender("Other")
                .setNumber("1234567890")
                .setBirthDate("30", "July", "2008")
                .setSubjectInput()
                .setHobbiesWrapper()
                .uploadPicture()
                .setCurrentAddress()
                .setState()
                .setCity();
        registrationFormPage.clickSubmit();
        registrationFormPage.checkResultsTableVisible()
                    .checkResult("Student Name", "Alex Egorov")
                    .checkResult("Student Email", "alex@egorov.com")
                    .checkResult("Date of Birth", "30 July,2008");
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        System.out.println("Test done fillFormTest");
    }

/*    @Test
    void fillFormWithMinimumDataTest() {
        registrationFormPage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setGender("Other");

        $("#userNumber").setValue("1234567890");
        $("#submit").click();
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive table").shouldHave(text("Alex"), text("Egorov"), text("1234567890"));*/
}
