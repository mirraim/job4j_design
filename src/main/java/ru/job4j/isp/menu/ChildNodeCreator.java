package ru.job4j.isp.menu;

public class ChildNodeCreator implements NodeCreator {
    @Override
    public Node create(Node prev, String name, String prefix) {
        StringBuilder nodeName = new StringBuilder(prefix);
        if (prev.getLevel() == 0) {
            nodeName.append(" ");
        }
        nodeName.append(prev.getName());
        int number = 1;
        StringBuilder parentNumber = new StringBuilder(prev.getParentNumber())
                                                            .append(prev.getNumber())
                                                            .append(".");
        nodeName.append("1.");
        return new Node(prev.getLevel() + 1, prev, number,
                            parentNumber.toString(), nodeName.toString());
    }
}
