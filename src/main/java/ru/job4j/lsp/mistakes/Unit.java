package ru.job4j.lsp.mistakes;

public abstract class Unit {
    private String name;
    private int level;
    private int hp;
    private int maxHp;
    private Race race;
    private int damage;

    public Unit(String name, int level, Race race) {
        this.name = name;
        this.level = level;
        this.maxHp = level * 10 + 50;
        this.hp = maxHp;
        this.race  = race;
        this.damage = level * 5 + 20;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getDamage() {
        return damage;
    }

    public int getLevel() {
        return level;
    }
}
