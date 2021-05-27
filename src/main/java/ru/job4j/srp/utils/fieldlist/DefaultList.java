package ru.job4j.srp.utils.fieldlist;

import ru.job4j.srp.Employee;

import java.util.List;

public class DefaultList implements FieldList {
    @Override
    public List<String> getHeaderList() {
        return List.of("Name", "Hired", "Fired", "Salary");
    }

    @Override
    public List<String> getList(Employee employee) {
        return List.of(
                employee.getName(),
                employee.getHired().getTime().toString(),
                employee.getFired().getTime().toString(),
                String.valueOf(employee.getSalary())
        );
    }
}
