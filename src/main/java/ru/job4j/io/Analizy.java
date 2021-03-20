package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Analizy {

    /**
     * Считывает данные из файла
     * Записывает в другой файл интервалы, когда система была неработоспособна
     * @param source - файл-источник
     * @param target - файл назначения
     */
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
        PrintWriter writer = new PrintWriter(new FileOutputStream(target))) {
            List<Event> events = load(reader);
            save(writer, events);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("./data/server.log", "./data/unavalable.csv");
    }

    private boolean hasProblem(String status) {
        return status.equals("400") || status.equals("500");
    }

    private boolean isWorking(String status) {
        return status.equals("200") || status.equals("300");
    }

    /**
     * Считывает данные из файла
     * Преобразует их в объект Event, если считанная строка соответствует условиям
     * Собирает все ненулевые объекты Event  в список
     * @param reader - поток ввода
     * @return
     */
    private List<Event> load(BufferedReader reader) {
        return reader.lines()
                .map(Analizy::createEvent)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * Ищет промежутки неработоспособности системы
     * и записывает их в файл
     * @param writer - поток вывода
     * @param events - список событий
     */
    private void save(PrintWriter writer, List<Event> events) {
        Event current = events.get(0);
        for (Event event : events) {
            if (isWorking(current.type) && hasProblem(event.type)) {
                current = event;
            } else if (hasProblem(current.type) && isWorking(event.type)) {
                writer.println(current.date + ";" + event.date);
                current = event;
            }
        }
    }

    private static boolean isValid(String[] message) {
        return message.length == 2;
    }

    /**
     * Создает объект Event, если строка соответствует требованиям
     * @param line
     * @return
     */
    private static Event createEvent(String line) {
        String[] message = line.split(" ");
        if (isValid(message)) {
           return new Event(message[0], message[1]);
        }
        return null;
    }

    public static class Event {
        String type;
        String date;

        public Event(String type, String date) {
            this.type = type;
            this.date = date;
        }
    }
}
