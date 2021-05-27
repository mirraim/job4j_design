package ru.job4j.srp.utils;

import ru.job4j.srp.Employee;
import ru.job4j.srp.utils.fieldlist.FieldList;
import ru.job4j.srp.utils.formatter.ReportFormatter;

import java.util.Comparator;
import java.util.Optional;

public interface ReportProperties {
    ReportFormatter getFormatter();
    FieldList getFieldList();
    Optional<Comparator<Employee>> getComparator();
}
