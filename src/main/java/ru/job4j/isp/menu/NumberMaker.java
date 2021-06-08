package ru.job4j.isp.menu;

public interface NumberMaker {
    default String makeNumber(String parentNumber, int number) {
        return new StringBuilder()
                .append(parentNumber)
                .append(number)
                .append(".").toString();
    }
}
