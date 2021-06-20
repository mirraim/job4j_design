package ru.job4j.isp.menu;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        return o1.getFullNumber().compareTo(o2.getFullNumber());
    }
}
