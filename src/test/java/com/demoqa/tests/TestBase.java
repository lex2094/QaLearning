package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.utils.RandomUtils;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;

import java.util.Locale;

public class TestBase extends RandomUtils {

    Faker faker = new Faker(new Locale("en"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String day = generateDay();
    String phone = faker.phoneNumber().subscriberNumber(10);
    String month = generateMonth();
    String year = generateYear();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
}
