package ru.job4j.kiss;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MaxMinTest {
    private List<Integer> list;

    @Before
    public void init() {
        list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(15);
        list.add(8);
        list.add(2);
    }

    @Test
    public void whenMax() {
        MaxMin max = new MaxMin();
        Integer rsl = max.max(list, Integer::compare);
        assertEquals(rsl, Integer.valueOf(15));
    }

    @Test
    public void whenMin() {
        MaxMin min = new MaxMin();
        Integer rsl = min.min(list, Integer::compare);
        assertEquals(rsl, Integer.valueOf(1));
    }
}