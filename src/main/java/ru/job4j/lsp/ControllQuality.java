package ru.job4j.lsp;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ControllQuality {

    public long fresh(Food food) {
        long term = food.getExpiryDate().toEpochDay() - food.getCreateDate().toEpochDay();
        long now = LocalDate.now().toEpochDay() - food.getCreateDate().toEpochDay();
        return now * 100 / term;
    }

    public void redistribute(List<Storage> storages) {
        List<Food> foods = storages.stream()
                .flatMap(storage -> storage.getList().stream())
                .collect(Collectors.toList());

        for (Food food : foods) {
            for (Storage storage : storages) {
                storage.add(food, fresh(food));
            }
        }
    }
}
