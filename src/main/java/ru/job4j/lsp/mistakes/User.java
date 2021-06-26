package ru.job4j.lsp.mistakes;

public class User {
    private String name;
    private int age;
    private String passport;
    private String birthSertificate;

    public User(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getBirthSertificate() {
        return birthSertificate;
    }

    public void setBirthSertificate(String birthSertificate) {
        this.birthSertificate = birthSertificate;
    }

    public String getName() {
        return name;
    }
}
