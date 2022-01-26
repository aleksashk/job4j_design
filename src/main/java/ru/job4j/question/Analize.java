package ru.job4j.question;

import java.util.HashSet;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int counterAddedUsers = 0;
        if (previous.size() < current.size()) {
            counterAddedUsers = current.size() - previous.size();
        }
        if (previous.size() == current.size()) {
            Set<Integer> userPrevId = new HashSet<>();
            for (User u : previous) {
                userPrevId.add(u.getId());
            }
            for (User u : current) {
                if (!userPrevId.contains(u.getId())) {
                    counterAddedUsers++;
                }
            }
        }

        int counterChangedUsers = 0;
        if (previous.size() == current.size()) {
            for (User uPrev : previous) {
                int userIdPrev = uPrev.getId();
                String userNamePrev = uPrev.getName();

                for (User uCur : current) {
                    int userIdCur = uCur.getId();
                    String userNameCur = uCur.getName();

                    if (userIdPrev == userIdCur && !userNamePrev.equals(userNameCur)) {
                        counterChangedUsers++;
                        break;
                    }
                }
            }
        }

        int counterRemovedUser = 0;
        if (previous.size() > current.size()) {
            counterRemovedUser = previous.size() - current.size();
        }
        if (previous.size() == current.size()) {
           Set<User> resultRemovedSet = new HashSet<>(previous);
           resultRemovedSet.removeAll(current);
           counterRemovedUser = resultRemovedSet.size();
        }

        return new Info(counterAddedUsers, counterChangedUsers, counterRemovedUser);
    }
}