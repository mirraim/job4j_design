package ru.job4j.isp.menu;

public interface NodeCreator {
    Node create(Node prev, String name, String prefix);
}
