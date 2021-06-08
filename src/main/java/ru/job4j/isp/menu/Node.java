package ru.job4j.isp.menu;

import java.util.Objects;

public class Node {
    private static final String NAME = "Задача ";
    private static final String PREFIX = "----";
    private int level;
    private Node prev;
    private int number;
    private String parentNumber;
    private String name;
    private Action action;

    public Node(int level, Node prev, int number, String parentNumber, String name) {
        this.level = level;
        this.prev = prev;
        this.number = number;
        this.parentNumber = parentNumber;
        this.name = name;
    }

    public static Node create(Node prev, NodeCreator creator) {
        return creator.create(prev, NAME, PREFIX);
    }

    public int getLevel() {
        return level;
    }

    public Node getPrev() {
        return prev;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getParentNumber() {
        return parentNumber;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
