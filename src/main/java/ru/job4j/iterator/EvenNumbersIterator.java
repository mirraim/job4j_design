package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private final int[] numbers;
    private int count = 0;

    public EvenNumbersIterator(final int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        if (count == numbers.length) {
            return false;
        }
        for (int i = count; i < numbers.length; i++) {
            if (isEven(numbers[i])) {
                return true;
            }
            count++;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[count++];
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
