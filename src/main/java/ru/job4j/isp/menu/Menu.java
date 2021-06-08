package ru.job4j.isp.menu;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Menu implements NumberMaker {
    private final Map<String, Node> menu;
    private Node lastNode;

    public Menu() {
        this.menu = new LinkedHashMap<>();
        this.lastNode = null;
    }

    public boolean add(int level) {
        Node current = createNode(level);
        if (current == null) {
            throw new IllegalArgumentException();
        }
        String number = makeNumber(current.getParentNumber(), current.getNumber());
        lastNode = current;
        return menu.put(number, current) == null;
    }

    public void choose(String key) {
        Node node = menu.get(key);
        node.getAction().execute();
    }

    public Map<String, Node> getMenu() {
        return menu;
    }

    public List<String> print() {
        return menu.values().stream()
                .map(Node::getName)
                .collect(Collectors.toList());
    }

    private Node createNode(int level) {
        if (lastNode == null) {
            if (level != 0) {
                throw new IllegalArgumentException();
            }
            return Node.create(lastNode, new FirstNodeCreator());
        }
        if (level == lastNode.getLevel()) {
            return Node.create(lastNode, new SameNodeCreator());
        }
        if (level == lastNode.getLevel() + 1) {
            return Node.create(lastNode, new ChildNodeCreator());
        }
        if (level < lastNode.getLevel() && level >= 0) {
            HighNodeCreator creator = new HighNodeCreator();
            creator.setLevel(level);
            return Node.create(lastNode, creator);
        }
        throw new IllegalArgumentException();
    }
}
