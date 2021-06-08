package ru.job4j.isp.menu;

public class FirstNodeCreator implements NodeCreator {
    @Override
    public Node create(Node prev, String name, String prefix) {
        StringBuilder nodeName = new StringBuilder(name);
        nodeName.append("1.");
        return new Node(0, null, 1, "", nodeName.toString());
    }
}
