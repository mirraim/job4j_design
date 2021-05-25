package ru.job4j.gc;

public class User {
    private int id;
    private String name;
    private short age;
    private boolean married;
    private char gender;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", id, name);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public short getAge() {
        return age;
    }

    public boolean isMarried() {
        return married;
    }

    public char getGender() {
        return gender;
    }
}
