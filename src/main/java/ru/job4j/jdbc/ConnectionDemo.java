package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // Чтение app.properties
        Config config = new Config("app.properties");
        config.load();

        // Регистрация драйвера
        Class.forName(config.value("driver_class"));

        // Подключение к postgres
        String url = config.value("url");
        String login = config.value("username");
        String password = config.value("password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {

        // Получение данных из БД
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
