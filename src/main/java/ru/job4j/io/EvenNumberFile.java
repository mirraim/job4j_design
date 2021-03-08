package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                System.out.println(isEven(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String isEven(String number) {
        int value = Integer.parseInt(number);
        if (value % 2 == 0) {
            return "Это число - четное";
        }
        return "Это число не является четным";
    }
}
