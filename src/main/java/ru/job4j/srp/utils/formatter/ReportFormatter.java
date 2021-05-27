package ru.job4j.srp.utils.formatter;

import java.util.List;

public interface ReportFormatter {

    String format(List<String> args);

    StringBuilder createHead(List<String> args);

    String close();
}
