package com.egor.mel8;

import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class ParsingCSV {

    ClassLoader cl = this.getClass().getClassLoader();

    @Test
    void parsCSV() throws Exception {
        try (InputStream getCSV = cl.getResourceAsStream("Team.csv");
             InputStreamReader getCSVir = new InputStreamReader(getCSV)) {
            CSVReader csvReader = new CSVReader(getCSVir);
            List<String[]> csvAsListString = csvReader.readAll();
            Assertions.assertArrayEquals(csvAsListString.get(1), new String[]{"Egor", "QA"});
        }
    }
}
