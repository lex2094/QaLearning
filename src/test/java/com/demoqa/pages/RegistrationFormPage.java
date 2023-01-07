package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormPage {

    private final static String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsModal resultsModal = new ResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            clickSubmit = $("#submit"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper").$(byText("Sports")),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            State = $("#react-select-3-input"),
            City =   $("#react-select-4-input");


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage clearFirstName() {
        firstNameInput.clear();
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);
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

    public RegistrationFormPage checkResultsTableVisible() {
        resultsModal.checkVisible();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultsModal.checkResult(key, value);
        return this;
    }
    public RegistrationFormPage clickSubmit() {
        clickSubmit.click();
        return this;
    }
    public RegistrationFormPage setSubjectInput(){
        subjectInput.setValue("Math").pressEnter();
        return this;
    }
    public RegistrationFormPage setHobbiesWrapper(){
        hobbiesWrapper.click();
        return this;
    }
    public RegistrationFormPage uploadPicture(){
        uploadPicture.uploadFromClasspath("img/1.png");
        return this;
    }
    public RegistrationFormPage setCurrentAddress(){
        currentAddress.setValue("This is new address for testing");
        return this;
    }
    public RegistrationFormPage setState() {
        State.setValue("NCR").pressEnter();
        return this;
    }
    public RegistrationFormPage setCity(){
        City.setValue("Noida").pressEnter();
        return this;
    }
}
