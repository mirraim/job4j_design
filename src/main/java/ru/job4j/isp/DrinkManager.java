package ru.job4j.isp;

public class DrinkManager implements Manager {
    @Override
    public boolean serve() {
        //some code
        return false;
    }

    @Override
    public void cook() {
        // Заглушка - напиток не требует приготовления
    }

    @Override
    public void throwOut() {
        //some code
    }

    @Override
    public void burn() {
        // Заглушка - напиток нельзя сжечь
    }

    @Override
    public void pour() {
        //some code
    }
}
