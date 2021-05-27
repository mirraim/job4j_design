package ru.job4j.srp.utils;

import ru.job4j.srp.Employee;
import ru.job4j.srp.utils.fieldlist.AccList;
import ru.job4j.srp.utils.fieldlist.FieldList;
import ru.job4j.srp.utils.formatter.OldFormatter;
import ru.job4j.srp.utils.formatter.ReportFormatter;

import java.util.Comparator;
import java.util.Optional;

public class AccProperties implements ReportProperties {
    ReportFormatter formatter;
    FieldList fieldList;

    public AccProperties() {
        this.formatter = new OldFormatter();
        this.fieldList = new AccList();
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
