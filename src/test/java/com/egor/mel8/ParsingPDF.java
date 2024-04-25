package com.egor.mel8;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParsingPDF {

    @Test
    void downloadAndParsingPDF() throws Exception {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File downloadPDF = $("a[href='junit-user-guide-5.10.2.pdf']").download();
        PDF pdf = new PDF(downloadPDF);
        Assertions.assertTrue(pdf.text.contains("JUnit 5 User Guide"));
    }
}
