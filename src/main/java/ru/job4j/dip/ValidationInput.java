package ru.job4j.dip;

public class ValidationInput {

    public boolean validate(String line) {
        try {
            int number = Integer.parseInt(line);
            if (number < 0) {
                // Здесь зависимость от консольного вывода, от которой нужно избавиться
                System.out.println("Число должно быть больше нуля");
                return false;
            }
        } catch (Exception e) {
            // Тут будет лучше использовать логгер
            System.out.println("Упс! Что-то пошло не так");
        }
        return true;
    }
}
