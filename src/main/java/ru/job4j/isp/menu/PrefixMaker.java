package ru.job4j.isp.menu;

public class PrefixMaker {
    public String getPrefix(Node node, String prefix) {
        StringBuilder rsl = new StringBuilder("");
        Node current = node;
        while (current.getParent() != null) {
            rsl.append(prefix);
            current = current.getParent();
        }
        return rsl.toString();
    }
}
