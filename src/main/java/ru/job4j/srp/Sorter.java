package ru.job4j.srp;

import java.util.Arrays;
import java.util.List;

/**
 * Этот класс преследует сразу три цели:
 * 1.Собирает сроки в список
 * 2. Сортирует эти строки
 * 3. Выводит отсортированный список
 * По принципу SRP нужно каждую из этих целей вынести  как минимум в отдельный метод,
 * а как максимум - в отдельный класс, с созданием соответствующего интерфейса (В зависимости от назначения программы).
 */
public class Sorter {

    public static void main(String[] args) {
        List<String> list = Arrays.asList(args);
        list.sort(String::compareTo);
        list.forEach(System.out::println);
    }
}
