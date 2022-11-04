package com.demoqa.pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsModal {

    private final static String TITLE_TEXT = "Thanks for submitting the form";

    public ResultsModal checkVisible() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT));

        return this;
    }
    public ResultsModal checkResult(String key, String value) {
        $(".table-responsive table").$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }
// I wanted to check, that the field is empty in form

/*    public ResultsModal checkEmptyResult (String key, String value){
        $(".table-responsive table").$(byText(key))
                .parent().shouldBe(empty);
        return this;
    }*/
}