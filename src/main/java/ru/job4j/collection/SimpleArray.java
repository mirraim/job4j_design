package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private T[] container;
    private int size = 0;
    private int modCount = 0;

    public SimpleArray(int length) {
        this.container = (T[]) new Object[length];
    }

    public SimpleArray() {
        this.container = (T[]) new Object[10];
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    public void add(T model) {
        if (isEnds()) {
            container = grow();
        }
        container[size++] = model;
        modCount++;
    }

    private boolean isEnds() {
        return container.length == size;
    }

    private T[] grow() {
        if (container.length == 0) {
            return Arrays.copyOf(container, 10);
        }
        return Arrays.copyOf(container, size * 2);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int count = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return count < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[count++];
            }
        };
    }
}
