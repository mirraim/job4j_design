package ru.job4j.io.filefinder;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class FileFinderTest {

    @Test
    public void searchWhenName() throws IOException {
        Predicate<Path> condition = new Condition().getPredicate(
                "checkstyle.xml",
                "name"
        );

        List<Path> result = FileFinder.search(Paths.get("/home/mirraim"), condition);
        List<Path> expected = List.of(
                Paths.get("/home/mirraim/projects/job4j_design/checkstyle.xml"),
                Paths.get("/home/mirraim/projects/job4j_elementary/checkstyle.xml"),
                Paths.get("/home/mirraim/projects/job4j_tracker/checkstyle.xml")
        );
        assertEquals(result, expected);
    }

    @Test
    public void searchWhenMaskEnd() throws IOException {
        Predicate<Path> condition = new Condition().getPredicate(
                "*.pdf",
                "mask"
        );

        List<Path> result = FileFinder.search(Paths.get("/home/mirraim/projects/job4j_design"), condition);
        List<Path> expected = List.of();
        assertEquals(result, expected);
    }

    @Test
    public void searchWhenMaskStart() throws IOException {
        Predicate<Path> condition = new Condition().getPredicate(
                "pair*",
                "mask"
        );

        List<Path> result = FileFinder.search(Paths.get("/home/mirraim/projects/job4j_design"), condition);
        List<Path> expected = List.of(
                Paths.get("/home/mirraim/projects/job4j_design/data/pair_with_comment.properties"),
                Paths.get("/home/mirraim/projects/job4j_design/data/pair_without_comment.properties"),
                Paths.get("/home/mirraim/projects/job4j_design/data/pair_invalid.properties")
        );
        assertEquals(result, expected);
    }

    @Test
    public void searchWhenMaskMiddle() throws IOException {
        Predicate<Path> condition = new Condition().getPredicate(
                "Forw*java",
                "mask"
        );

        List<Path> result = FileFinder.search(Paths.get("/home/mirraim/projects/job4j_design"), condition);
        List<Path> expected = List.of(
                Paths.get("/home/mirraim/projects/job4j_design/src/test/java/ru/job4j/collection/ForwardLinkedTest.java"),
                Paths.get("/home/mirraim/projects/job4j_design/src/main/java/ru/job4j/collection/ForwardLinked.java")
        );
        assertEquals(result, expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void searchWhenIllegalMask() throws IOException {
        Predicate<Path> condition = new Condition().getPredicate(
                "F**java",
                "mask"
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void searchWhenIllegalType() throws IOException {
        Predicate<Path> condition = new Condition().getPredicate(
                "*java",
                "maska"
        );
    }

    @Test
    public void searchWhenRegex() throws IOException {
        Predicate<Path> condition = new Condition().getPredicate(
                "_",
                "regex"
        );

        List<Path> result = FileFinder.search(Paths.get("/home/mirraim/projects/job4j_design/data"), condition);
        List<Path> expected = List.of(
                Paths.get("/home/mirraim/projects/job4j_design/data/pair_with_comment.properties"),
                Paths.get("/home/mirraim/projects/job4j_design/data/pair_without_comment.properties"),
                Paths.get("/home/mirraim/projects/job4j_design/data/pair_invalid.properties")
        );
        assertEquals(result, expected);
    }
}