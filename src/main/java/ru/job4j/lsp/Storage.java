package ru.job4j.lsp;

import java.util.List;

public interface Storage {
    List<Food> getList();
    boolean add(Food food, long fresh);
}
