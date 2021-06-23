package ru.job4j.lsp.mistakes;

public class Bird implements Animal {
    @Override
    public void run() {
        System.out.println("Я бегаю очень медленно");
    }

    @Override
    public void fly() {
        System.out.println("Я лечу!!!");
    }

    @Override
    public void swim() {
        throw new IllegalArgumentException();
    }
}
