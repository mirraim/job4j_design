package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<E> implements Iterable<E> {
    private SimpleArray<E> array;

    public SimpleSet() {
        this.array = new SimpleArray<E>();
    }

    public boolean add(E e) {
        Iterator<E> it = array.iterator();
        while (it.hasNext()) {
            if (Objects.equals(it.next(), e)) {
                return false;
            }
        }
        array.add(e);
        return true;
    }


    @Override
    public Iterator<E> iterator() {
        return array.iterator();
    }
}
