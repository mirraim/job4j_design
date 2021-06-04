package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
    private List<Food> foods;

    public Shop() {
        this.foods = new ArrayList<>();
    }

    public Shop(List<Food> foods) {
        this.foods = foods;
    }

    @Override
    public List<Food> getList() {
        return foods;
    }

    @Override
    public boolean add(Food food, long fresh) {
        if (fresh >= 25 && fresh < 75) {
            foods.add(food);
            return true;
        } else if (fresh < 100 && fresh >= 75) {
            food.setDiscount(25);
            foods.add(food);
            return true;
        }
        return false;
    }
}
