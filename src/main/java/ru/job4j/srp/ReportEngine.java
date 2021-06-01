package ru.job4j.srp;

import ru.job4j.srp.utils.ReportProperties;
import ru.job4j.srp.utils.formatter.ReportFormatter;

import java.util.List;
import java.util.function.Predicate;

public class ReportEngine implements Report {
    private Store store;
    private ReportProperties properties;

    public ReportEngine(Store store, ReportProperties properties) {
        this.store = store;
        this.properties = properties;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        ReportFormatter formatter = properties.getFormatter();
        List<Employee> employees = store.findBy(filter);
        if (properties.getComparator().isPresent()) {
            employees.sort(properties.getComparator().get());
        }
        return formatter.format(employees, properties.getFieldList());
    }
}
