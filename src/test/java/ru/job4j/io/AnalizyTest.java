package ru.job4j.io;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void whenUnavailable() {
        Analizy analizy = new Analizy();
        analizy.unavailable("./data/server.log", "./data/unavalable.csv");
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("./data/unavalable.csv"))) {
           lines = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> expected = List.of("10:57:01;10:59:01", "11:01:02;11:02:02");
        assertEquals(lines, expected);
    }
}