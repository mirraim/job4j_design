package ru.job4j.isp;

import java.util.List;

public class Fighter implements Flyer {

    @Override
    public void fly() {
        // some code
    }

    @Override
    public boolean land() {
        // some code
        return true;
    }

    @Override
    public List<String> getPassengers() {
        // Тут заглушка - истребитель не может взять пассажиров
        return null;
    }

    @Override
    public void turn() {
        // some code
    }
}
