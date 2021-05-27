package ru.job4j.srp.utils.fieldlist;

import ru.job4j.srp.Employee;

import java.util.List;

public class AccList implements FieldList {

    @Override
    public List<String> getHeaderList() {
        return List.of("Name", "Hired", "Fired", "Salary");
    }

    @Override
    public List<String> getList(Employee employee) {
        String[] salary = String.format("%.2f", employee.getSalary()).split(",");
        return List.of(
                employee.getName(),
                employee.getHired().getTime().toString(),
                employee.getFired().getTime().toString(),
                String.format("%s руб. %s коп.", salary[0], salary[1])
        );
    }
}
