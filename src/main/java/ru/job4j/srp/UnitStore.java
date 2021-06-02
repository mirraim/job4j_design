package ru.job4j.srp;

import java.sql.*;

public class UnitStore {

    /**
     * Получение подключения к базе данных можно считать отдельной задачей,
     * лучше будет вынести его в отдельный класс,
     * чтобы в случае необходимости можно было, например, написать фасад для роллбэка.     *
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/idea_db",
                "postgres",
                "123"
                );
        return connection;
    }

    public void save(Unit unit) {
        try (PreparedStatement statement = getConnection().prepareStatement(
                "insert into unit (name, hitpoints) values (?, ?);")) {
            statement.setString(1, unit.getName());
            statement.setInt(2, unit.getHitpoints());
            statement.execute();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Этот метод управляет состоянием экземпляра другого класса без обращения к базе данных
     * Его нужно вынести в отдельный класс.
     */
    public void attack(Unit unit) {
        int current = unit.getHitpoints();
        unit.setHitpoints(current - 5);
    }
}
