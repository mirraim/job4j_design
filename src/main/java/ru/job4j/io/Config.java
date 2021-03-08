package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (isValid(line)) {
                    String[] pair = getPair(line);
                    values.put(pair[0], pair[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        if (!values.containsKey(key)) {
            System.out.println("Key is not found");
            return "";
        }
        return values.get(key);
    }

    public Set<String> getKeys() {
        return values.keySet();
    }

    private static boolean isValid(String line) {
        return !line.equals("") && !line.startsWith("#");
    }

    private static String[] getPair(String line) {
        String[] rsl = line.split("=");
        if (rsl.length != 2 || rsl[0].isEmpty() || rsl[1].isEmpty()) {
            throw new IllegalArgumentException();
        }
        return rsl;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}
