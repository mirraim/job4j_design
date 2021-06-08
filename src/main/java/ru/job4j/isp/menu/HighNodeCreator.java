package ru.job4j.isp.menu;

public class HighNodeCreator extends PrefixMaker implements NodeCreator, NumberMaker, LevelHandler {
    private int level;

    @Override
    public Node create(Node prev, String name, String prefix) {
        StringBuilder nodeName = new StringBuilder();
        Node current = prev.getPrev();
        while (current.getLevel() != level) {
            current = current.getPrev();
        }
        String parentNumber = current.getParentNumber();
        int number = current.getNumber() + 1;
        nodeName.append(name).append(makeNumber(parentNumber, number));
        return new Node(level, prev, number, parentNumber, nodeName.toString());
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }
}
