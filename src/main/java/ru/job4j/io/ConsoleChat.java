package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(
                                    new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(
                     new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            boolean isStopped = false;
            String line = in.readLine();
            bw.write(line + System.lineSeparator());
            while (!line.equals(OUT)) {
                if (line.equals(STOP)) {
                    isStopped = true;
                }
                if (line.equals(CONTINUE)) {
                    isStopped = false;
                }
                if (!isStopped) {
                    String botAnswer = answer();
                    System.out.println(botAnswer);
                    bw.write(botAnswer + System.lineSeparator());
                }
                line = in.readLine();
                bw.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("data/log.txt", "result.txt");
        cc.run();
    }

    private String answer() {
        List<String> answersList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(botAnswers, Charset.forName("WINDOWS-1251")))) {
            answersList = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (answersList.size() == 0) {
            throw new IllegalArgumentException("Список ответов пуст");
        }
        int index = new Random().nextInt(answersList.size());
        return answersList.get(index);
    }
}
