package com.egor.mel8.Json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class ParsingJSON {

    @Test
    void parsingJSON() throws Exception {
        File json = new File("src/test/resources/Egor.json");
        Stats stats = new ObjectMapper().readValue(json, Stats.class);
        Assertions.assertEquals(stats.getSalaries()[2], "30 000");
        Assertions.assertEquals(stats.getName(), "Egor");
    }
}
