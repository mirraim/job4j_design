package ru.job4j;

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
        if (data.length == 0) {
            return false;
        }
        for (int i = row; i < data.length; i++) {
            if (row == data.length - 1) {
                return column < data[row].length;
            }
            if (data[row].length == 0 || data[row].length == column) {
                row++;
                column = 0;
            }
        }
        return row < data.length - 1;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }

}
