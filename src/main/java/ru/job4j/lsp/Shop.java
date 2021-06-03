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
        List<Food> current = foods;
        foods = new ArrayList<>();
        return current;
    }

    @Override
    public void add(Food food, long fresh) {
        if (fresh >= 25 && fresh < 75) {
            foods.add(food);
        } else if (fresh < 100 && fresh >= 75) {
            food.setDiscount(25);
            foods.add(food);
        } else {
            System.out.println("Это магазин, вам не сюда");
        }
    }
}
