package ru.job4j.isp.menu;

public class PrefixMaker {
    public String getPrefix(int level, String prefix) {
        StringBuilder rsl = new StringBuilder("");
        if (level != 0) {
            rsl.append(String.valueOf(prefix).repeat(Math.max(0, level)));
            rsl.append(" ");
        }
        return rsl.toString();
    }
}
