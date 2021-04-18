package ru.job4j.io.filefinder;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Condition {
    public Predicate<Path> getPredicate(String fileInfo, String searchType) {
        if (searchType.equals("name")) {
            return findName(fileInfo);
        }
        if (searchType.equals("mask")) {
            return findRegex(preparePattern(fileInfo));
        }
        if (searchType.equals("regex")) {
            return findRegex(fileInfo);
        }
        throw new IllegalArgumentException("Invalid type of search");
    }


    private Predicate<Path> findName(String fileInfo) {
        return path -> path.toFile().getName().equals(fileInfo);
    }

    private Predicate<Path> findRegex(String fileInfo) {
        return path -> {
            Pattern pattern = Pattern.compile(fileInfo);
            Matcher matcher = pattern.matcher(path.toFile().getName());
            return matcher.find();
        };
    }

    private String preparePattern(String mask) {
        StringBuilder rsl = new StringBuilder();
        for (int i = 0; i < mask.length(); i++) {
            char symbol = mask.charAt(i);
            if (symbol == '*') {
                rsl.append(".*");
            } else if (symbol == '.') {
                rsl.append("//.");
            } else {
                rsl.append(symbol);
            }
        }
        return rsl.toString();
    }
}
