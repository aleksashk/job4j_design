package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.util.Objects.hash;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return hash(name, children, birthday);
    }

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar(1984, Calendar.MAY, 24);
        calendar.set(Calendar.HOUR, 4);
        calendar.set(Calendar.MINUTE, 37);
        calendar.set(Calendar.SECOND, 9);
        calendar.set(Calendar.MILLISECOND, 45);

        User user1 = new User("Alex", 2, calendar);
        User user2 = new User("Alex", 2, calendar);

        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());

        for (Map.Entry<User, Object> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue() + " ---> " + e.getKey().hashCode() + " --->" + hash(e.getKey().hashCode()) % 15 + ";");
        }
    }
}
