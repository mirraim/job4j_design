package ru.job4j.dip;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemManager {
    List<Item> items;

    public ItemManager() {
        this.items = new ArrayList<>();
    }

    public void add(Item item) {
        items.add(item);
    }

    public void remove(Item item) {
        items.remove(item);
    }

    public Item findById(int id) {
        Objects.checkIndex(id, items.size());
        return items.get(id);
    }
}
