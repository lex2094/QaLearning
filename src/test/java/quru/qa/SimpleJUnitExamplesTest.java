package quru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleJUnitExamplesTest {

    @Disabled("Wait something")
    @Test
    void simpleTest() {
    }

    @DisplayName("Text about something")
    void simpleTest1() {
    }

    @Test
    void simpleTest2() {
    }
}
