package com.egor.mel8;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DownloadUploadFile {

    @Test
    void downloadWithInputStream() throws Exception {
        open("https://github.com/FasterXML/jackson-databind/blob/2.18/README.md");
        File download = $("a[href='https://github.com/FasterXML/jackson-databind/raw/2.18/README.md'").download();
        try (InputStream is = new FileInputStream(download)) {
            byte[] downloadAsBytes = is.readAllBytes();
            String downloadAsString = new String(downloadAsBytes, StandardCharsets.UTF_8);
            Assertions.assertTrue(downloadAsString.contains("Jackson Data Processor"));
        }
    }

    @Test
    void downloadWithReader() throws Exception {
        open("https://github.com/FasterXML/jackson-databind/blob/2.18/README.md");
        File download = $("a[href='https://github.com/FasterXML/jackson-databind/raw/2.18/README.md'").download();
        int charInDownload;
        StringBuilder downloadAsString = new StringBuilder();
        try (FileReader fr = new FileReader(download, StandardCharsets.UTF_8)) {
            while ((charInDownload = fr.read()) != -1) {
                downloadAsString.append((char) charInDownload);
            }
            Assertions.assertTrue(downloadAsString.toString().contains("Jackson Data Processor"));
        }
    }

    @Test
    void uploadTest() {
        Configuration.browserSize = "1920x1080";
        open("https://tus.io/demo");
        $("input[type='file'").uploadFromClasspath("uploadFile.txt");
        $(byText("The upload is complete!")).should(exist);
    }
}
