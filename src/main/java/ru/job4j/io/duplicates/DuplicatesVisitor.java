package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Map<FileProperty, Path> dist = new HashMap<>();
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(attrs.size(), file.getFileName().toString());
        if (dist.containsKey(fileProperty)) {
            System.out.println("Найдены дубликаты: " + System.lineSeparator()
                    + file.toAbsolutePath() + System.lineSeparator()
                    + dist.get(fileProperty).toAbsolutePath());
        } else {
            dist.put(fileProperty, file);
        }
        return super.visitFile(file, attrs);
    }

}
