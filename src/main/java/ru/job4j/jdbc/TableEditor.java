package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {
    private Connection connection;

    private final Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try {
            connection = getConnection();
        } catch (Exception e) {
            System.out.println("Connection failed");
        }
    }

    public void createTable(String tableName) throws SQLException {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "create table if not exists %s(%s, %s);",
                        tableName,
                        "id serial primary key",
                        "name varchar(255)"
                );
                statement.execute(sql);
            }
    }

    public void dropTable(String tableName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("drop table %s;", tableName);
            statement.execute(sql);
        }
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "alter table %s add column %s %s;",
                    tableName,
                    columnName,
                    type
            );
            statement.execute(sql);
        }
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "alter table %s drop column %s;",
                    tableName,
                    columnName
            );
            statement.execute(sql);
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "alter table %s rename column %s to %s;",
                    tableName,
                    columnName,
                    newColumnName
            );
            statement.execute(sql);
        }
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    private Connection getConnection() throws Exception {
        properties.load(new FileInputStream("app.properties"));
        Class.forName(properties.getProperty("driver_class"));
        return DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("username"), properties.getProperty("password"));
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws SQLException {
        TableEditor tableEditor = new TableEditor(new Properties());
        tableEditor.createTable("test_table");
        System.out.println(tableEditor.getScheme("test_table"));
        System.out.println("_______________________");

        tableEditor.addColumn("test_table", "age", "int");
        System.out.println(tableEditor.getScheme("test_table"));
        System.out.println("_______________________");

        tableEditor.dropColumn("test_table", "age");
        System.out.println(tableEditor.getScheme("test_table"));
        System.out.println("_______________________");

        tableEditor.renameColumn("test_table", "name", "username");
        System.out.println(tableEditor.getScheme("test_table"));
        System.out.println("_______________________");

        tableEditor.dropTable("test_table");
        System.out.println(tableEditor.getScheme("test_table"));
    }
}
