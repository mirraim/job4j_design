package ru.job4j.isp;

public class DessertManager implements  Manager {
    @Override
    public boolean serve() {
        //some code
        return false;
    }

    @Override
    public void cook() {
        // Заглушка - десерт не требует приготовления
    }

    @Override
    public void throwOut() {
        //some code
    }

    @Override
    public void burn() {
        // Заглушка - десерт нельзя сжечь
    }

    @Override
    public void pour() {
        // Заглушка - десерт нельзя налить
    }
}
