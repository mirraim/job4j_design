package ru.job4j.isp.menu;

public class SameNodeCreator implements NodeCreator {
    @Override
    public Node create(Node node, String name, String prefix) {
        StringBuilder nodeName = new StringBuilder();
        int number = node.getNumber() + 1;
        String fullNumber = number + ".";
        nodeName.append(fullNumber).append(" ").append(name);
        return new Node(node, number, fullNumber, name, nodeName.toString());
    }
}
