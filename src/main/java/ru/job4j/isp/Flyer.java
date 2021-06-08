package ru.job4j.isp;

import java.util.List;

public interface Flyer {
    void fly();
    boolean land();
    List<String> getPassengers();
    void turn();
}
