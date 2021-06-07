package ru.job4j.lsp.park;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarParking implements Parking {
    private Vehicle[] ordinaryLot;
    private Vehicle[] truckLot;

    public CarParking(int ordinaryLot, int trackLot) {
        this.ordinaryLot = new Vehicle[ordinaryLot];
        this.truckLot = new Vehicle[trackLot];
    }


    @Override
    public boolean park(Vehicle car) {
        if (car.getSize() == 1) {
            if (!parkCar(car)) {
                car.setLotType(LotType.TRUCK);
                return parkTruck(car);
            }
            return true;
        }
        if (car.getSize() > 1) {
            if (!parkTruck(car)) {
                car.setLotType(LotType.CAR);
                return parkCar(car);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean leave(Vehicle car) {
        LotType type = car.getLotType();
        if (type.equals(LotType.CAR)) {
            return leaveParking(ordinaryLot, car);
        }
        if (type.equals(LotType.TRUCK)) {
            return leaveParking(truckLot, car);
        }
        return false;
    }

    @Override
    public Map<LotType, List<Vehicle>> getCars() {
        Map<LotType, List<Vehicle>> cars = new HashMap<>();
        List<Vehicle> vehicles = Arrays.stream(ordinaryLot)
                                .collect(Collectors.toList());
        List<Vehicle> truckList = Arrays.asList(truckLot);
        vehicles.addAll(truckList);
        cars.put(LotType.CAR, getList(vehicles, vehicle -> vehicle.getSize() == 1));
        cars.put(LotType.TRUCK, getList(vehicles, vehicle -> vehicle.getSize() > 1));
        return cars;
    }

    private boolean parkTruck(Vehicle vehicle) {
        for (int i = 0; i < truckLot.length; i++) {
            if (truckLot[i] == null) {
                truckLot[i] = vehicle;
                return true;
            }
        }
        return false;
    }

    private boolean parkCar(Vehicle vehicle) {
        int index = freeLots(vehicle.getSize());
        if (index == -1) {
            return false;
        }
        for (int i = index; i < index + vehicle.getSize(); i++) {
            ordinaryLot[i] = vehicle;
        }
        return true;
    }

    private int freeLots(int lots) {
        int count = 0;
        for (int i = 0; i < ordinaryLot.length; i++) {
            if (ordinaryLot[i] == null) {
                count++;
                if (count == lots) {
                    return i - count + 1;
                }
            } else {
                count = 0;
            }
        }
        return -1;
    }

    private boolean leaveParking(Vehicle[] vehicles, Vehicle vehicle) {
        int count = 0;
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i].equals(vehicle)) {
                count++;
                vehicles[i] = null;
                if (count == vehicle.getSize()) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<Vehicle> getList(List<Vehicle> vehicles, Predicate<Vehicle> predicate) {
        return  vehicles.stream()
                .filter(Objects::nonNull)
                .filter(predicate)
                .distinct()
                .collect(Collectors.toList());
    }
}
