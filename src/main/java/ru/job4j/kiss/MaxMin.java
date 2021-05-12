package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return calculate(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return calculate(value, comparator.reversed());
    }

    private <T> T calculate(List<T> value, Comparator<T> comparator) {
        T rsl = value.get(0);
        for (T el : value) {
            rsl = comparator.compare(rsl, el) > 0 ? rsl : el;
        }
        return rsl;
    }
}
