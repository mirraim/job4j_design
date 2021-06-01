package ru.job4j.srp.utils.formatter;

import ru.job4j.srp.Employee;
import ru.job4j.srp.utils.fieldlist.FieldList;

import java.util.List;

public class OldFormatter implements ReportFormatter {
    @Override
    public String format(List<Employee> employees, FieldList fieldList) {
        StringBuilder text = createHead(fieldList.getHeaderList());
        for (Employee employee : employees) {
            List<String> args = fieldList.getList(employee);
            for (String arg : args) {
                text.append(arg)
                    .append(";");
            }
            text.append(System.lineSeparator());
        }
        return text.toString();
    }

    public StringBuilder createHead(List<String> args) {
        StringBuilder text = new StringBuilder();
        for (String arg : args) {
            text.append(arg)
                 .append("; ");
        }
        text.append(System.lineSeparator());
        return text;
    }
}
