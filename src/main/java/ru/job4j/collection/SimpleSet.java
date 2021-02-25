package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<E> implements Iterable<E> {
    private final SimpleArray<E> array;

    public SimpleSet() {
        this.array = new SimpleArray<>();
    }

    public boolean add(E e) {
        if (!contains(e)) {
            array.add(e);
            return true;
        }
        return false;
    }

    private boolean contains(E e) {
        for (E value : array) {
            if (Objects.equals(value, e)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Iterator<E> iterator() {
        return array.iterator();
    }
}
