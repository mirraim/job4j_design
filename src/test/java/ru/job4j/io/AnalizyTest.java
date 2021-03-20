package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenUnavailable() throws IOException {
        File sourse = folder.newFile("sourse.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(sourse)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println();
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(sourse.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("./data/unavalable.csv"))) {
           reader.lines().forEach(rsl::append);
        }
        String expected = "10:57:01;10:59:01" + "11:01:02;11:02:02";
        assertEquals(rsl.toString(), expected);
    }
}