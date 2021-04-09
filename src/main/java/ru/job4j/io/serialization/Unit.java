package ru.job4j.io.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "unit")
@XmlAccessorType
public class Unit {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private int hitpoints;
    @XmlElementWrapper(name = "statuses")
    @XmlElement(name = "status")
    private String[] skills;
    @XmlElement
    private Weapon weapon;
    @XmlAttribute
    private boolean isActive;

    public Unit(String name, int hitpoints, Weapon weapon, String... skills) {
        this.name = name;
        this.hitpoints = hitpoints;
        this.skills = skills;
        this.weapon = weapon;
        this.isActive = false;
    }

    public Unit() {
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

    public static void main(String[] args) throws JAXBException {
        Weapon weapon = new Weapon(20, "Sword");
        final Unit unit = new Unit("Warrior", 200, weapon, "Attack", "protection");
        JAXBContext context = JAXBContext.newInstance(Unit.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(unit, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        } catch (Exception e) {

        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Unit result = (Unit) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
