package quru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Selenide;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;
import quru.qa.data.model.Teacher;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.System.in;
import static org.assertj.core.api.Assertions.assertThat;

public class FileParseTest {

    ClassLoader cl = FileParseTest.class.getClassLoader();

    @Test
    void pdfTest() throws Exception {
        Selenide.open("https://junit.org/junit5/docs/current/user-guide/");
        File downloadedFile = $("a[href= 'junit-user-guide-5.9.1.pdf']").download();
        PDF pdf = new PDF(downloadedFile);
        assertThat(pdf.author).contains("Sam Brannen");
        System.out.println("1");
    }
    @Test
    void xlsTest() throws Exception{
        InputStream is = cl.getResourceAsStream("test.xls");
        XLS xls = new XLS(is);
        assertThat(
                xls.excel.getSheetAt(0)
                .getRow(1)
                .getCell(1)
                .getStringCellValue())
                .isEqualTo("ООО \"ВИГОР\"");
        is.close();
        System.out.println("1");
    }

    @Test
    void csvTest() throws Exception{
        InputStream is = cl.getResourceAsStream("qa_guru.csv");
        CSVReader reader = new CSVReader(new InputStreamReader(is));
        List<String[]> content = reader.readAll();
        System.out.println("1");
        String[] row = content.get(1);
        assertThat(row[0]).isEqualTo("Tuchs");
        assertThat(row[1]).isEqualTo("Junit 5");
    }
    // please create zip file
    @Test
    void zipTest() throws Exception{
        InputStream is = cl.getResourceAsStream("sample-zip-file.zip");
        ZipInputStream zis = new ZipInputStream(is);
        ZipEntry entry = null;
        while ((entry = zis.getNextEntry()) != null) {
            var entryName = entry.getName();
            System.out.println(entry.getName());
        }
    }

    @Test
    void jsonTest() throws Exception {
        InputStream is = cl.getResourceAsStream("teacher.json");
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(new InputStreamReader(is), JsonObject.class);
        assertThat(jsonObject.get("name").getAsString()).isEqualTo("Alex");
        System.out.println("11");
        assertThat(jsonObject.get("isGoodTeacher").getAsBoolean()).isTrue();
        assertThat(jsonObject.get("passport").getAsJsonObject().get("number").getAsInt()).isEqualTo(123456);
        System.out.println("1");
    }

    @Test
    void jsonTest1() throws Exception {
        InputStream is = cl.getResourceAsStream("teacher.json");
        Gson gson = new Gson();
        Teacher teacher = gson.fromJson(new InputStreamReader(is), JsonObject.class);
        assertThat(teacher.name).isEqualTo("Alex");
        assertThat(teacher.isGoodTeacher).isTrue();
        assertThat(teacher.passport.number).isEqualTo(123456);
        System.out.println("1");
    }
}
