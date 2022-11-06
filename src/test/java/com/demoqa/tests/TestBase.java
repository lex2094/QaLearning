package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    static String firstName = "Ivan",
            lastName = "Ivanov",
            email = "test@test.test",
            day = "30",
            phone = "1234567890",
            month = "July",
            year = "2000";

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
}
