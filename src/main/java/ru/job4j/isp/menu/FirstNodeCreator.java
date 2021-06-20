package ru.job4j.isp.menu;

public class FirstNodeCreator implements NodeCreator {
    @Override
    public Node create(Node prev, String name, String prefix) {
        StringBuilder nodeName = new StringBuilder("1. ");
        nodeName.append(name);
        return new Node(null, 1, "1.", name, nodeName.toString());
    }
}
