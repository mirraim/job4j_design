package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private T[] arr;
    private int size = 0;

    public SimpleArray(int length) {
        this.arr = (T[]) new Object[length];
    }

    public void add(T model) {
        Objects.checkIndex(size, arr.length);
            arr[size++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, size);
            arr[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
            System.arraycopy(arr, index + 1, arr, index, arr.length - 1 - index);
            arr[arr.length - 1] = null;
            size--;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
            return arr[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return arr[count++];
            }
        };
    }

    @Override
    public String toString() {
        return "SimpleArray{"
                + "arr=" + Arrays.toString(arr) + '}';
    }
}
