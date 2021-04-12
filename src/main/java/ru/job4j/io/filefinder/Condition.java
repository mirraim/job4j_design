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
            return findMask(fileInfo);
        }
        if (searchType.equals("regex")) {
            return findRegex(fileInfo);
        }
        throw new IllegalArgumentException("Invalid type of search");
    }


    private Predicate<Path> findName(String fileInfo) {
        return path -> path.toFile().getName().equals(fileInfo);
    }

    private Predicate<Path> findMask(String fileInfo) {
        int index = fileInfo.indexOf("*");
        if (index == -1 || index != fileInfo.lastIndexOf("*")) {
            throw new IllegalArgumentException("Invalid mask");
        }
        String start = fileInfo.substring(0, index);
        String end = fileInfo.substring(index + 1);
        if (index == 0) {
            return path -> path.toFile().getName().endsWith(end);
        }
        if (index == fileInfo.length() - 1) {
            return path -> path.toFile().getName().startsWith(start);
        }
        return path -> path.toFile().getName().startsWith(start)
                && path.toFile().getName().endsWith(end);
    }

    private Predicate<Path> findRegex(String fileInfo) {
        return path -> {
            Pattern pattern = Pattern.compile(fileInfo);
            Matcher matcher = pattern.matcher(path.toFile().getName());
            return matcher.find();
        };
    }
}
