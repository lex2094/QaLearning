package quru.qa.data;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$;

public class SelenideFileTest {

    @Test
    void selenideFileDownloadTest() throws FileNotFoundException {
        Selenide.open ("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloadedFile = $("#raw-url").download();
    }
}
