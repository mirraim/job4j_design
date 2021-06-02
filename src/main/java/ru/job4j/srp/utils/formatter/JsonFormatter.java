package ru.job4j.srp.utils.formatter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.srp.Employee;
import ru.job4j.srp.utils.Employees;
import ru.job4j.srp.utils.fieldlist.FieldList;

import java.util.List;

public class JsonFormatter implements ReportFormatter {
    @Override
    public String format(List<Employee> employeeList, FieldList fieldList) {
        Employees employees = new Employees();
        employees.setEmployees(employeeList);
        Gson gson = new GsonBuilder().create();
        return gson.toJson(employees) + System.lineSeparator();
    }
}
