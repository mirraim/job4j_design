package ru.job4j.srp;

import ru.job4j.srp.utils.fieldlist.FieldList;
import ru.job4j.srp.utils.formatter.ReportFormatter;
import ru.job4j.srp.utils.ReportProperties;

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
        FieldList fieldList = properties.getFieldList();
        StringBuilder text = formatter.createHead(fieldList.getHeaderList());
        List<Employee> employees = store.findBy(filter);
        if (properties.getComparator().isPresent()) {
            employees.sort(properties.getComparator().get());
        }
        for (Employee employee : employees) {
            text.append(formatter.format(fieldList.getList(employee)));
        }
        text.append(formatter.close());
        return text.toString();
    }
}
