package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Map<Integer, String> prev = previous.stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        Map<Integer, String> curr = current.stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        Info info = new Info();
        Set<Integer> ids = new HashSet<>();
        for (int id : prev.keySet()) {
            if (curr.containsKey(id)) {
               if (!curr.get(id).equals(prev.get(id))) {
                   info.changed++;
               }
            } else {
                info.deleted++;
            }
        }
        info.added = curr.size() + info.deleted - prev.size();
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
