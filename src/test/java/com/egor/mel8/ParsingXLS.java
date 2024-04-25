package com.egor.mel8;

import com.codeborne.selenide.Configuration;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParsingXLS {

    @Test
    void downloadAndParsingPDF() throws Exception {
        Configuration.browserSize = "1920x1080";
        open("https://excelvba.ru/programmes/Teachers?ysclid=lfcu77j9j9951587711");
        File downloadPDF = $("a[href='https://ExcelVBA.ru/sites/default/files/teachers.xls']").download();
        XLS xls = new XLS(downloadPDF);
        Assertions.assertEquals(xls.excel.getSheetAt(2).getRow(4).getCell(1).getStringCellValue(), "Белый Владимир Михайлович");
    }
}
