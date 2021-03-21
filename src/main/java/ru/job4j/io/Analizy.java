package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {

    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
        PrintWriter writer = new PrintWriter(new FileOutputStream(target))) {
            List<String> lines = load(reader);
            save(writer, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("./data/server.log", "./data/unavalable.csv");
    }

    private boolean hasProblem(String status) {
        return status.startsWith("400") || status.startsWith("500");
    }

    private boolean isWorking(String status) {
        return status.startsWith("200") || status.startsWith("300");
    }

    private List<String> load(BufferedReader reader) throws IOException {
        List<String> rsl = new ArrayList<>();
        String current = reader.readLine();
        for (String line = current; line != null; line = reader.readLine()) {
            if (hasProblem(current) && isWorking(line)) {
                rsl.add(current.split(" ")[1] + ";"
                        + line.split(" ")[1]);
                current = line;
            } else if (hasProblem(line) && isWorking(current)) {
                current = line;
            }
        }
        return rsl;
    }

    private void save(PrintWriter writer, List<String> lines) {
        lines.forEach(writer::println);
    }

}
