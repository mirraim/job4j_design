package ru.job4j.dip;

import java.util.List;

public interface Store {
    boolean add(Message message);
    boolean delete(int id);
    List<Message> getAll();
}
