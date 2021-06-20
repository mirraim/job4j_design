package ru.job4j.isp.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    private String name;
    private static final String PREFIX = "  ";
    private Node parent;
    private int number;
    private String fullNumber;
    private String fullName;
    private Action action;
    private List<Node> children;

    public Node(Node prev, int number, String fullNumber, String name, String fullName) {
        this.parent = prev;
        this.number = number;
        this.fullNumber = fullNumber;
        this.name = name;
        this.fullName = fullName;
        this.children = new ArrayList<>();
    }

    public static Node create(Node prev, NodeCreator creator, String name) {
        return creator.create(prev, name, PREFIX);
    }

    public Node getParent() {
        return parent;
    }

    public int getNumber() {
        return number;
    }

    public String getFullName() {
        return fullName;
    }

    public String getFullNumber() {
        return fullNumber;
    }

    public List<Node> getChildren() {
        return children;
    }

    public String getName() {
        return name;
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
        sb.append("name='").append(fullName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void add(Node node) {
        children.add(node);
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
        return Objects.equals(fullName, node.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }
}
