package ru.job4j.srp.utils.fieldlist;

import ru.job4j.srp.Employee;

import java.util.List;

public class HRList implements FieldList {
    @Override
    public List<String> getHeaderList() {
        return List.of("Name", "Salary");
    }

    @Override
    public List<String> getList(Employee employee) {
        return List.of(
                employee.getName(),
                String.valueOf(employee.getSalary())
        );
    }
}
