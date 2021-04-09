package ru.job4j.io.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.job4j.io.serialization.Weapon;

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

    public String getName() {
        return name;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public String[] getSkills() {
        return skills;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public boolean isActive() {
        return isActive;
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
        JSONObject weaponJson = new JSONObject();
        weaponJson.put("name", weapon.getName());
        weaponJson.put("damage", weapon.getDamage());

        final Unit unit = new Unit("Warrior", 200, weapon, "Attack", "protection");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", unit.getName());
        jsonObject.put("hitpoints", unit.getHitpoints());
        jsonObject.put("skills", new JSONArray(unit.getSkills()));
        jsonObject.put("weapon", weaponJson);
        jsonObject.put("isActive", unit.isActive);

        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(unit).toString());

    }
}
