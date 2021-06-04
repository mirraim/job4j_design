package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {
    private List<Food> foods;

    public Warehouse() {
        this.foods = new ArrayList<>();
    }

    public Warehouse(List<Food> foods) {
        this.foods = foods;
    }

    @Override
    public List<Food> getList() {
        return foods;
    }

    @Override
    public boolean add(Food food, long fresh) {
        if (fresh < 25) {
            foods.add(food);
            return true;
        }
        return false;
    }
}
