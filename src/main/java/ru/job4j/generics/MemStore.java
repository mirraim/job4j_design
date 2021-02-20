package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        try {
            T element = this.findById(id);
            int index = mem.indexOf(element);
            mem.remove(element);
            mem.add(index, model);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        try {
            T element = this.findById(id);
            mem.remove(element);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    @Override
    public T findById(String id) {
        return mem.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
