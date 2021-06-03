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
        List<Food> current = foods;
        foods = new ArrayList<>();
        return current;
    }

    @Override
    public void add(Food food, long fresh) {
        if (fresh < 25) {
            foods.add(food);
        } else {
            System.out.println("Продукт недостаточно свежий");
        }
    }
}
