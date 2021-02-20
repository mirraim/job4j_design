package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public class RoleStore implements Store<Role> {
    private final Map<String, Role> store = new HashMap<>();

    @Override
    public void add(Role model) {
        store.putIfAbsent(model.getId(), model);
    }

    @Override
    public boolean replace(String id, Role model) {
        if (store.containsKey(id)) {
            store.put(id, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (store.containsKey(id)) {
            store.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Role findById(String id) {
        return store.get(id);
    }
}
