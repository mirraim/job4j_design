package ru.job4j.lsp.mistakes;

public class Forest {

    public void move(Animal animal) {
        if (animal instanceof Fish) {
            animal.swim();
        }
        if (animal instanceof Bird) {
            animal.fly();
        }
    }
}
