package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Map<Integer, String> curr = current.stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        Info info = new Info();
        Set<Integer> ids = new HashSet<>();
        for (int i = 0; i < previous.size(); i++) {
            Integer id = previous.get(i).getId();
            if (curr.containsKey(id)) {
               if (!curr.get(id).equals(previous.get(i).getName())) {
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
