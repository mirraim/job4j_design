package ru.job4j.lsp.mistakes;

public class Healer extends Unit {

    public Healer(String name, int level, Race race) {
        super(name, level, race);
    }

    @Override
    public int getDamage() {
        return -this.getDamage();
    }
}
