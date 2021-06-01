package ru.job4j.srp.utils.formatter;

import ru.job4j.srp.Employee;
import ru.job4j.srp.utils.fieldlist.FieldList;

import java.util.List;

public interface ReportFormatter {
    String format(List<Employee> employees, FieldList fieldList);
}
