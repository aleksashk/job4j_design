package ru.job4j.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private Properties properties;

    public TableEditor(Properties properties) throws SQLException, IOException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws IOException, ClassNotFoundException, SQLException {
        properties.setProperty("driver", "org.postgresql.Driver");
        properties.setProperty("url", "jdbc:postgresql://localhost:5432/idea_db");
        properties.setProperty("login", "postgres");
        properties.setProperty("password", "password");
        File file = new File("testEditor.properties");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        properties.store(fileOutputStream, "sql_connection");
        try (FileInputStream fileProperties = new FileInputStream(file)) {
            properties.load(fileProperties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        Class.forName(driver);
        this.connection = DriverManager.getConnection(url, login, password);
    }

    public void createTable(String tableName) {
        try (Statement st = connection.createStatement()) {
            String query = String.format("CREATE table if not exists %s(%s,%s);", tableName, "id serial primary key", "name varchar(40)");
            st.execute(query);
            System.out.println(TableEditor.getTableScheme(connection, tableName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dropTable(String tableName) {
        try (Statement st = connection.createStatement()) {
            String query = String.format("drop table %s", tableName);
            st.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        try (Statement st = connection.createStatement()) {
            String query = String.format("ALTER TABLE %s ADD COLUMN %s %s", tableName, columnName, type);
            st.execute(query);
        }
    }

    public void dropColumn(String tableName, String columnName) {
        try (Statement st = connection.createStatement()) {
            String query = String.format("ALTER TABLE %s DROP COLUMN %s", tableName, columnName);
            st.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        try (Statement st = connection.createStatement()) {
            String query = String.format("ALTER TABLE %s RENAME COLUMN %s to %s", tableName, columnName, newColumnName);
            st.execute(query);
            System.out.println(TableEditor.getTableScheme(connection, tableName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    private static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/idea_db";
        String login = "postgres";
        String password = "password";
        return DriverManager.getConnection(url, login, password);
    }
}
