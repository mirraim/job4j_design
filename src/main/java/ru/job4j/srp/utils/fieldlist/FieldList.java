package ru.job4j.srp.utils.fieldlist;

import ru.job4j.srp.Employee;

import java.util.List;

public interface FieldList {
    List<String> getHeaderList();

    List<String> getList(Employee employee);
}
