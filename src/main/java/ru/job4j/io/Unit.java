package ru.job4j.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Unit {
    private String name;
    private int hitpoints;
    private String[] skills;
    private Weapon weapon;
    private boolean isActive;

    public Unit(String name, int hitpoints, Weapon weapon, String... skills) {
        this.name = name;
        this.hitpoints = hitpoints;
        this.skills = skills;
        this.weapon = weapon;
        this.isActive = false;
    }

    @Override
    public String toString() {
        return "Unit{"
                + "name='" + name + '\''
                + ", hitpoints=" + hitpoints
                + ", skills=" + Arrays.toString(skills)
                + ", weapon=" + weapon
                + ", isActive=" + isActive + '}';
    }

    public static void main(String[] args) {
        Weapon weapon = new Weapon(20, "Sword");
        final Unit unit = new Unit("Warrior", 200, weapon, "Attack", "protection");
        final Gson gson = new GsonBuilder().create();
        final String gsonUnit = gson.toJson(unit);
        System.out.println(gsonUnit);
        final Unit another = gson.fromJson(gsonUnit, Unit.class);
        System.out.println(another);
    }
}
