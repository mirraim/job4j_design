package ru.job4j.isp.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Menu {
    private final Map<String, Node> menu;
    private Node lastNode;

    public Menu() {
        this.menu = new HashMap<>();
        this.lastNode = null;
    }

    public boolean add(String name) {
        return menu.put(name, createNode(null, name)) == null;
    }

    public boolean add(String name, Action action) {
        Node current = createNode(null, name);
        current.setAction(action);
        return menu.put(name, current) == null;
    }

    public boolean add(String parent, String name) {
       Node parentNode = menu.get(parent);
       if (parentNode == null) {
           throw new IllegalArgumentException();
       }
        return menu.put(name, createNode(parentNode, name)) == null;
    }

    public boolean add(String parent, String name, Action action) {
        Node parentNode = menu.get(parent);
        if (parentNode == null) {
            throw new IllegalArgumentException();
        }
        Node current = createNode(parentNode, name);
        current.setAction(action);
        return menu.put(name, current) == null;
    }

    public boolean choose(String key) {
        Node node = menu.get(key);
        if (node != null && node.getAction() != null) {
            node.getAction().execute();
            return true;
        }
        return false;
    }

    public boolean setAction(String name, Action action) {
        Node node = menu.get(name);
        if (node == null) {
            return false;
        }
        node.setAction(action);
        return true;
    }

    public List<String> getMenu() {
        return menu.values().stream()
                .sorted(new NodeComparator())
                .map(Node::getName)
                .collect(Collectors.toList());
    }

    public String print() {
        StringBuilder rsl = new StringBuilder();
        menu.values().stream()
                .sorted(new NodeComparator())
                .map(Node::getFullName)
                .forEach(str -> rsl.append(str).append(System.lineSeparator()));
        return rsl.toString();
    }

    private Node createNode(Node parent,  String name) {
        if (parent == null) {
            if (lastNode == null) {
                lastNode = Node.create(null, new FirstNodeCreator(), name);
            } else {
                lastNode = Node.create(lastNode, new SameNodeCreator(), name);
            }
            return lastNode;
        }
        return Node.create(parent, new ChildNodeCreator(), name);
    }
}
