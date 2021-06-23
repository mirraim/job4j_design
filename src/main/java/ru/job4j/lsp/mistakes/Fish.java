package ru.job4j.lsp.mistakes;

public class Fish implements Animal {
    @Override
    public void run() {
        throw new IllegalArgumentException();
    }

    @Override
    public void fly() {
        throw new IllegalArgumentException();
    }

    @Override
    public void swim() {
        System.out.println("Я плыву!");
    }
}
