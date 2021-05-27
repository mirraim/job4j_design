package ru.job4j.srp.utils.formatter;

import java.util.List;

public class OldFormatter implements ReportFormatter {
    @Override
    public String format(List<String> args) {
        StringBuilder text = new StringBuilder();
        for (String arg : args) {
            text.append(arg)
                 .append(";");
        }
        text.append(System.lineSeparator());
        return text.toString();
    }

    @Override
    public StringBuilder createHead(List<String> args) {
        StringBuilder text = new StringBuilder();
        for (String arg : args) {
            text.append(arg)
                 .append("; ");
        }
        text.append(System.lineSeparator());
        return text;
    }

    @Override
    public String close() {
        return "";
    }
}
