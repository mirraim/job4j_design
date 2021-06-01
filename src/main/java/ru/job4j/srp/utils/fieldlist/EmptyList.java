package ru.job4j.srp.utils.fieldlist;

import ru.job4j.srp.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmptyList implements FieldList {
    @Override
    public List<String> getHeaderList() {
        return new ArrayList<>();
    }

    @Override
    public List<String> getList(Employee employee) {
        return new ArrayList<>();
    }
}
