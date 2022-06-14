package ru.job4j.jdbc;

import java.io.FileInputStream;
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

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName(properties.getProperty("driver"));
        connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("login"),
                properties.getProperty("password")
        );
    }

    public void createTable(String tableName) {
        createStatement(String.format("CREATE table if not exists %s(%s);", tableName, "id serial primary key"));
    }

    public void dropTable(String tableName) {
        createStatement(String.format("drop table %s", tableName));
    }

    public void addColumn(String tableName, String columnName, String type) {
        createStatement(String.format("ALTER TABLE %s ADD COLUMN %s %s", tableName, columnName, type));
    }

    public void dropColumn(String tableName, String columnName) {
        createStatement(String.format("ALTER TABLE %s DROP COLUMN %s", tableName, columnName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        createStatement(String.format("ALTER TABLE %s RENAME COLUMN %s to %s", tableName, columnName, newColumnName));
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

    private void createStatement(String query) {
        try (Statement st = connection.createStatement()) {
            st.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();

        try (FileInputStream fio = new FileInputStream("app.properties")) {
            properties.load(fio);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String tableTitle = "TableEditor";
        try (TableEditor te = new TableEditor(properties)) {
            System.out.printf("Create table %s %n", tableTitle);
            te.createTable(tableTitle);
            System.out.println((getTableScheme(te.connection, tableTitle)));
            te.addColumn(tableTitle, "name", "varchar");
            System.out.println((getTableScheme(te.connection, tableTitle)));
            te.dropColumn(tableTitle, "name");
            System.out.println((getTableScheme(te.connection, tableTitle)));
            te.renameColumn(tableTitle, "id", "idColumn");
            System.out.println((getTableScheme(te.connection, tableTitle)));
        }
    }
}
