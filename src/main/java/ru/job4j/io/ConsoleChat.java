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
        boolean isStopped = false;
        List<String> answers = answer();
        Random random = new Random();
        List<String> log = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(
                                    new InputStreamReader(System.in))) {
            String line = in.readLine();
            log.add(line);
            while (!line.equals(OUT)) {
                if (line.equals(STOP)) {
                    isStopped = true;
                }
                if (line.equals(CONTINUE)) {
                    isStopped = false;
                }
                if (!isStopped) {
                    String botAnswer = answers.get(random.nextInt(answers.size() - 1));
                    System.out.println(botAnswer);
                    log.add(botAnswer);
                }
                line = in.readLine();
                log.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeLog(log);
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("data/log.txt", "result.txt");
        cc.run();
    }

    private List<String> answer() {
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
        return answersList;
    }

    private void writeLog(List<String> lines) {
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            for (String mess: lines) {
                bw.write(mess);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
