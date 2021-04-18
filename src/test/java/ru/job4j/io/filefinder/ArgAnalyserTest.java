package ru.job4j.io.filefinder;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ArgAnalyserTest {

    @Test
    public void whenOf() {
        String[] arg = {"find.jar",
                        "-d=/home/mirraim/",
                        "-n=*.txt",
                        "-t=mask",
                        "-o=log.txt"};
        ArgAnalyser analyser = ArgAnalyser.of(arg);
        List<String> result = List.of(
                analyser.getDirectory(),
                analyser.getFileInfo(),
                analyser.getSearchType(),
                analyser.getOutput()
        );
        List<String> expected = List.of(
                "/home/mirraim/",
                "*.txt",
                "mask",
                "log.txt"
        );
        assertEquals(result, expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenEmptyDir() {
        String[] arg = {"find.jar",
                "-n=*.txt",
                "-t=mask",
                "-o=log.txt"};
        ArgAnalyser analyser = ArgAnalyser.of(arg);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenEmptyFileInfo() {
        String[] arg = {"find.jar",
                "-d=/home/mirraim/",
                "-t=mask",
                "-o=log.txt"};
        ArgAnalyser analyser = ArgAnalyser.of(arg);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenEmptySearchType() {
        String[] arg = {"find.jar",
                "-d=/home/mirraim/",
                "-n=*.txt",
                "-o=log.txt"};
        ArgAnalyser analyser = ArgAnalyser.of(arg);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenEmptyOutput() {
        String[] arg = {"find.jar",
                "-d=/home/mirraim/",
                "-n=*.txt",
                "-t=mask", };
        ArgAnalyser analyser = ArgAnalyser.of(arg);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIllegalParam() {
        String[] arg = {"find.jar",
                "-d=",
                "-n=*.txt",
                "-t=mask", };
        ArgAnalyser analyser = ArgAnalyser.of(arg);
    }
}