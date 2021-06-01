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
        long temp = Math.round(employee.getSalary() * 100);
        String sal = String.valueOf(temp);
        int index = sal.length() - 2;
        String rub = sal.substring(0, index);
        String kop = sal.substring(index);

        return List.of(
                employee.getName(),
                employee.getHired().getTime().toString(),
                employee.getFired().getTime().toString(),
                String.format("%s руб. %s коп.", rub, kop)
        );
    }
}
