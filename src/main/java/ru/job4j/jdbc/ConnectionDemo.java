package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDemo {
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void load() throws IOException {
        properties = new Properties();
        try (InputStream inputStream = ConnectionDemo.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(inputStream);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        ConnectionDemo connectionDemo = new ConnectionDemo();
        connectionDemo.load();
        String name = connectionDemo.getProperties().getProperty("jdbc.Driver");
        String url = connectionDemo.getProperties().getProperty("jdbc.url");
        String login = connectionDemo.getProperties().getProperty("jdbc.username");
        String password = connectionDemo.getProperties().getProperty("jdbc.password");
        Class.forName(name);

        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
            System.out.println(metaData.getDatabaseProductName());
        }
    }
}
