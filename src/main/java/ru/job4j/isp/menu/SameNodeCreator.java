package ru.job4j.isp.menu;

public class SameNodeCreator extends PrefixMaker implements NodeCreator, NumberMaker {
    @Override
    public Node create(Node prev, String name, String prefix) {
        StringBuilder nodeName = new StringBuilder();
        nodeName.append(getPrefix(prev.getLevel(), prefix));
        int number = prev.getNumber() + 1;
        String parentNumber = prev.getParentNumber();
        nodeName.append(name).append(makeNumber(parentNumber, number));
        return new Node(prev.getLevel(), prev, number, parentNumber, nodeName.toString());
    }
}
