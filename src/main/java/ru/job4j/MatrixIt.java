package ru.job4j;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (Arrays.stream(data).flatMapToInt(Arrays::stream).count() == 0) {
            return false;
        }
        if (row == data.length - 1) {
            return column < data[row].length;
        }
        return row < data.length - 1;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while (column >= data[row].length) {
            column = 0;
            row++;
        }
        return data[row][column++];
    }

}
