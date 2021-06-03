package ru.job4j.lsp.park;

public class CarParking implements Parking {
    private final int ordinaryLot;
    private final int trackLot;
    private int busyLot;
    private int busyTrack;


    public CarParking(int ordinaryLot, int trackLot) {
        this.ordinaryLot = ordinaryLot;
        this.trackLot = trackLot;
        busyLot = 0;
        busyTrack = 0;
    }

    @Override
    public int getOrdinaryLot() {
        return ordinaryLot;
    }

    @Override
    public int getTrackLot() {
        return trackLot;
    }

    @Override
    public int getBusyLot() {
        return busyLot;
    }

    @Override
    public void setBusyLot(int busyLot) {
        this.busyLot = busyLot;
    }

    @Override
    public int getBusyTrack() {
        return busyTrack;
    }

    @Override
    public void setBusyTrack(int busyTrack) {
        this.busyTrack = busyTrack;
    }
}
