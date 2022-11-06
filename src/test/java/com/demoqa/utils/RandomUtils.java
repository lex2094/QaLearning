package com.demoqa.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;

public class RandomUtils {

    private static final String randomDate =
            LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70)))).toString();

    public static String generateDay() {
        LocalDate localDate = LocalDate.parse(randomDate);
        return String.valueOf(localDate.getDayOfMonth());
    }
    public static String generateMonth() {
        LocalDate localDate = LocalDate.parse(randomDate);
        return localDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }
    public static String generateYear() {
        LocalDate localDate = LocalDate.parse(randomDate);
        return String.valueOf(localDate.getYear());
    }
}


