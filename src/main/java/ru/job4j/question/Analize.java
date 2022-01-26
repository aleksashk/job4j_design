package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int counterAddedUsers;
        int counterChangedUsers = 0;
        int counterRemovedUser = 0;

        Map<Integer, String> currentMap = new HashMap<>();
        for (User user : current) {
            currentMap.put(user.getId(), user.getName());
        }

        for (User user : previous) {
            String curUserName = currentMap.get(user.getId());
            if (curUserName != null && curUserName.equals(user.getName())) {
                currentMap.remove(user.getId());
            }
            if (curUserName != null && !curUserName.equals(user.getName())) {
                currentMap.remove(user.getId());
                counterChangedUsers++;
            }
            if (curUserName == null) {
                counterRemovedUser++;
            }
        }
        counterAddedUsers = currentMap.size();

        return new Info(counterAddedUsers, counterChangedUsers, counterRemovedUser);
    }
}