package ru.job4j.io.serialization;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "weapon")
public class Weapon {
    @XmlAttribute
    private int damage;
    @XmlAttribute
    private String name;

    public Weapon(int damage, String name) {
        this.damage = damage;
        this.name = name;
    }

    public Weapon() {
    }

    @Override
    public String toString() {
        return "Weapon{"
                + "damage=" + damage
                + ", name='" + name + '\''
                + '}';
    }
}
