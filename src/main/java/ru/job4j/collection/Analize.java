package ru.job4j.collection;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Map<Integer, String> curr = current.stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        Info info = new Info();
        for (User user : previous) {
            if (curr.containsKey(user.getId())) {
               if (!curr.get(user.getId()).equals(user.getName())) {
                   info.changed++;
               }
            } else {
                info.deleted++;
            }
        }
        info.added = curr.size() + info.deleted - previous.size();
        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }
}
