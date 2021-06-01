package ru.job4j.srp;

import java.util.List;

/**
 * Это класс-модель. В нем не должно быть логики.
 * метод addSkill должен быть вынесен в отдельный класс.
 */
public class Unit {
    private String name;
    private String[] skills;
    private int hitpoints;
    private List<String> equipment;

    public Unit(String name, String[] skills, int hitpoints, List<String> equipment) {
        this.name = name;
        this.skills = skills;
        this.hitpoints = hitpoints;
        this.equipment = equipment;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public List<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<String> equipment) {
        this.equipment = equipment;
    }

    public boolean addSkill(String skill) {
        boolean rsl = false;
        for (int i = 0; i < skills.length; i++) {
            if (skills[i] == null) {
                skills[i] = skill;
                rsl = true;
                break;
            }
        }
        return rsl;
    }

}
