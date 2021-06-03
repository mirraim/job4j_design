package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
        List<Food> foods = new ArrayList<>();
    @Override
    public List<Food> getList() {
        return foods;
    }

    @Override
    public void add(Food food, long fresh) {
        if (fresh <= 100) {
            System.out.println("Этот продукт еще можно продать!");
        }
    }
}
