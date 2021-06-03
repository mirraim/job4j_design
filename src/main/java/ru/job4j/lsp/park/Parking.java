package ru.job4j.lsp.park;

public interface Parking {
    int getOrdinaryLot();

    int getTrackLot();

    int getBusyLot();

    void setBusyLot(int busyLot);

    int getBusyTrack();

    void setBusyTrack(int busyTrack);
}
