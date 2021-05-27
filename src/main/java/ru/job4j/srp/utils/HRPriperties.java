package ru.job4j.srp.utils;

import ru.job4j.srp.Employee;
import ru.job4j.srp.utils.fieldlist.FieldList;
import ru.job4j.srp.utils.fieldlist.HRList;
import ru.job4j.srp.utils.formatter.OldFormatter;
import ru.job4j.srp.utils.formatter.ReportFormatter;

import java.util.Comparator;
import java.util.Optional;

public class HRPriperties implements ReportProperties {
    ReportFormatter formatter;
    FieldList fieldList;
    Optional<Comparator<Employee>> comparator;

    public HRPriperties() {
        this.formatter = new OldFormatter();
        this.fieldList = new HRList();
        this.comparator = Optional.of((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
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
        return comparator;
    }
}
