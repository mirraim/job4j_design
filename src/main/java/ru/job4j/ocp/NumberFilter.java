package ru.job4j.ocp;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Вместо перечисления множества способов отфильтровать
 * можно просто добавить лямбду в параметр одного метода
 */
public class NumberFilter {

    public List<Integer> filterEven(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
    }

    public List<Integer> filterPositive(List<Integer> numbers) {
        return numbers.stream().filter(n -> n > 0).collect(Collectors.toList());
    }
}
