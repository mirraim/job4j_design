package ru.job4j.io.serialisation;

public class Weapon {
    private int damage;
    private String name;

    public Weapon(int damage, String name) {
        this.damage = damage;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Weapon{"
                + "damage=" + damage
                + ", name='" + name + '\''
                + '}';
    }
}
