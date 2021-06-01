package ru.job4j.srp.utils;

import ru.job4j.srp.Employee;
import ru.job4j.srp.utils.fieldlist.EmptyList;
import ru.job4j.srp.utils.fieldlist.FieldList;
import ru.job4j.srp.utils.formatter.JsonFormatter;
import ru.job4j.srp.utils.formatter.ReportFormatter;

import java.util.Comparator;
import java.util.Optional;

public class JsonProperties implements ReportProperties {
    private ReportFormatter formatter;
    private FieldList fieldList;

    public JsonProperties() {
        this.formatter = new JsonFormatter();
        this.fieldList = new EmptyList();
    }

    @Override
    public ReportFormatter getFormatter() {
        return formatter;
    }

    @Override
    public FieldList getFieldList() {
        return fieldList;
    }

    @Override
    public Optional<Comparator<Employee>> getComparator() {
        return Optional.empty();
    }
}
