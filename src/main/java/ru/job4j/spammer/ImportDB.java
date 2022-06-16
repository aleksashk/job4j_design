package ru.job4j.spammer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {

    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines()
                    .filter(s -> s.contains(";"))
                    .map(s -> s.split(";"))
                    .filter(string -> {
                        if (string.length != 2 || string[0].isBlank() || string[1].isBlank()) {
                            throw new IllegalArgumentException("Wrong data.");
                        }
                        return true;
                    })
                    .forEach(s -> users.add(new User(s[0], s[1])));
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            try (PreparedStatement ps = cnt.prepareStatement("insert into users (name, email) values (?, ?)")) {
                for (User user : users) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    System.out.printf("User name: %s, email: %s was added to the database.%s",
                            user.name, user.email, System.lineSeparator());

                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        try (InputStream in = ImportDB.class.getClassLoader().getResourceAsStream("app.properties")) {
            config.load(in);
        }
        ImportDB db = new ImportDB(config, "./dump.txt");
        db.save(db.load());
    }
}