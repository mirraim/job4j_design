package ru.job4j.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shell {
    private List<String> names;

    public void cd(String path) {
        if (names == null || path.startsWith("/")) {
            names = new ArrayList<>(List.of(path.split("/")));
        } else if (path.startsWith("..")) {
            names.remove(names.size() - 1);
            if (path.length() > 2) {
                names.addAll(Arrays.asList(path.substring(3).split("/")));
            }
        } else {
            names.addAll(Arrays.asList(path.split("/")));
        }
    }

    public String pwd() {
        StringBuilder rsl = new StringBuilder();
        for (String token : names) {
            if (!token.isEmpty()) {
                rsl.append("/").append(token);
            }
        }
        if (rsl.length() == 0) {
            rsl.append("/");
        }
        return rsl.toString();
    }
}
