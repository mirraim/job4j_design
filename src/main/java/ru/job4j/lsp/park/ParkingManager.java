package ru.job4j.lsp.park;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager implements Manager {
    CarParking parking;
    List<Car> cars;

    public ParkingManager(CarParking parking) {
        this.parking = parking;
        cars = new ArrayList<>();
    }

    @Override
    public boolean park(Car car) {
        return false;
    }

    @Override
    public boolean leave(Car car) {
        return false;
    }
}
