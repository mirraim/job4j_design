package ru.job4j.isp.menu;

public class ChildNodeCreator extends PrefixMaker implements NodeCreator {
    @Override
    public Node create(Node prev, String name, String prefix) {
        StringBuilder nodeName = new StringBuilder(prefix);
        int number = prev.getChildren().size() + 1;
        StringBuilder fullNumber = new StringBuilder(prev.getFullNumber())
                                                        .append(number)
                                                        .append(".");
        nodeName.append(getPrefix(prev, prefix))
                .append(fullNumber)
                .append(" ")
                .append(name);
        Node current = new Node(prev, number, fullNumber.toString(), name, nodeName.toString());
        prev.add(current);
        return current;
    }
}
