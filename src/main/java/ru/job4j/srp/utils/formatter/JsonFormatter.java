package ru.job4j.srp.utils.formatter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.srp.Employee;
import ru.job4j.srp.utils.fieldlist.FieldList;

import java.util.List;

public class JsonFormatter implements ReportFormatter {
    @Override
    public String format(List<Employee> employees, FieldList fieldList) {
        StringBuilder builder = new StringBuilder();
        Gson gson = new GsonBuilder().create();
        for (Employee employee : employees) {
            builder.append(gson.toJson(employee))
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
