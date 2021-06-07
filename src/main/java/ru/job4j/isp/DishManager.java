package ru.job4j.isp;

public class DishManager implements Manager {

    @Override
    public boolean serve() {
        //some code
        return true;
    }

    @Override
    public void cook() {
        //some code
    }

    @Override
    public void throwOut() {
        //some code
    }

    @Override
    public void burn() {
        //some code
    }

    @Override
    public void pour() {
        // Заглушка - блюдо нельзя налить
    }
}
