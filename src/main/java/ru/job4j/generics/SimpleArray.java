package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private T[] arr;
    private int size;

    public SimpleArray(int length) {
        this.arr = (T[]) new Object[length];
    }

    public void add(T model) {
        if (Objects.checkIndex(size, arr.length) == size) {
            arr[size++] = model;
        }
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, size - 1);
            arr[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, arr.length);
            System.arraycopy(arr, index, arr, index + 1, arr.length - 1 - index);
            arr[arr.length - 1] = null;
            size--;
    }

    public T get(int index) {
        Objects.checkIndex(index, arr.length);
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

}
