package ru.job4j.lsp.park;

public class Truck implements Vehicle {
    private int size;
    private LotType type;

    public Truck(int size) {
        this.size = size;
        this.type = LotType.TRACK;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public LotType getLotType() {
        return null;
    }

    @Override
    public boolean setLotType(LotType type) {
        return false;
    }
}
