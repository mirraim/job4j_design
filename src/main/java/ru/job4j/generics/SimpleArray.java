package ru.job4j.generics;

import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> {
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
        if (Objects.checkIndex(index, size) == index) {
            arr[index] = model;
        }
    }

    public void remove(int index) {
        if (Objects.checkIndex(index, arr.length) == index) {
            System.arraycopy(arr, index, arr, index + 1, arr.length - 1 - index);
            arr[arr.length - 1] = null;
            size--;
        }
    }

    public T get(int index) {
        if (Objects.checkIndex(index, arr.length) == index) {
            return arr[index];
        }
        throw new NoSuchElementException();
    }
}
