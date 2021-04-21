package ru.job4j.io.filefinder;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.io.UsageLog4j;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class FileFinder {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try {
            ArgAnalyser analyser;
            analyser = ArgAnalyser.of(args);
            Path directory = Paths.get(analyser.getDirectory());
            Predicate<Path> condition = new Condition().getPredicate(
                    analyser.getFileInfo(),
                    analyser.getSearchType());
            List<Path> result = search(directory, condition);
            write(analyser.getOutput(), result);
        } catch (IllegalArgumentException | IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void write(String target, List<Path> paths) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(target, Charset.forName("WINDOWS-1251")))) {
            for (Path path : paths) {
                writer.write(path.toAbsolutePath().toString());
                writer.newLine();
            }
        }
    }
}
