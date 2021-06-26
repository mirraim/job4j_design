package ru.job4j.lsp.mistakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;

public class Registration {
    BufferedReader reader;
    Writer writer;

    public Registration(BufferedReader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public User register() throws IOException {
        User user = requestName();
        requestAge(user);
        requestDoc(user);
        return user;
    }

    public User requestName() throws IOException {
        writer.write("Введите имя");
        String name = reader.readLine();
        return new User(name);
    }

    public void requestAge(User user) throws IOException {
        writer.write("Введите возраст");
        int age = Integer.parseInt(reader.readLine());
        user.setAge(age);
    }

    public void requestDoc(User user) throws IOException {
        if (user.getAge() < 14) {
            requestBirthSert(user);
        } else {
            requestPassport(user);
        }
    }

    public void requestPassport(User user) throws IOException {
        writer.write("Введите номер паспорта");
        user.setPassport(reader.readLine());
    }

    public void requestBirthSert(User user) throws IOException {
        writer.write("Введите возраст");
       user.setBirthSertificate(reader.readLine());
    }
}
