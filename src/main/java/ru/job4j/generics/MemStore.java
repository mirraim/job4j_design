package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = findIndexById(id);
        if (index == -1) {
            return false;
        }
        mem.set(index, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        int index = findIndexById(id);
        if (index == -1) {
            return false;
        }
        mem.remove(index);
        return true;
    }

    @Override
    public T findById(String id) {
        int index = findIndexById(id);
        return index >= 0 ? mem.get(index) : null;
    }

    public int findIndexById(String id){
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
