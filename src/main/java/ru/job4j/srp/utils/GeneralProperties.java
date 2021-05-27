package ru.job4j.srp.utils;

import ru.job4j.srp.Employee;
import ru.job4j.srp.utils.fieldlist.DefaultList;
import ru.job4j.srp.utils.fieldlist.FieldList;
import ru.job4j.srp.utils.formatter.OldFormatter;
import ru.job4j.srp.utils.formatter.ReportFormatter;

import java.util.Comparator;
import java.util.Optional;

public class GeneralProperties implements ReportProperties {
    private ReportFormatter formatter;
    private FieldList fieldList;

    public GeneralProperties() {
        this.formatter = new OldFormatter();
        this.fieldList = new DefaultList();
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
