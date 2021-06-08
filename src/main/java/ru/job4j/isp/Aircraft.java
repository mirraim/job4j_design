package ru.job4j.isp;

import java.util.List;

public class Aircraft implements Flyer {
    List<String> passengers;

    public Aircraft(List<String> passengers) {
        this.passengers = passengers;
    }

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
        return passengers;
    }

    @Override
    public void turn() {
        // тут заглушка - для пассажирского самолета не нужно выполнять фигуры высшего пилотажа
    }
}
