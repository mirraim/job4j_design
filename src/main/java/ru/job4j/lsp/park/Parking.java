package ru.job4j.lsp.park;

import java.util.List;
import java.util.Map;

public interface Parking {
    boolean park(Vehicle car);
    boolean leave(Vehicle car);
    Map<LotType, List<Vehicle>> getCars();
}
