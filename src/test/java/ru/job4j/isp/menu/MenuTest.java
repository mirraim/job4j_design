package ru.job4j.isp.menu;

import org.junit.Assert;
import org.junit.Test;

public class MenuTest {

    @Test(expected = IllegalArgumentException.class)
    public void add() {
        Menu menu = new Menu();
        menu.add(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addIllegal() {
        Menu menu = new Menu();
        menu.add(0);
        menu.add(-1);
    }

    @Test
    public void whenFirst() {
        Menu menu = new Menu();
        menu.add(0);
        StringBuilder expected = new StringBuilder()
                .append("Задача 1.")
                .append(System.lineSeparator());
        StringBuilder rsl = new StringBuilder();
        menu.print().forEach(name -> rsl.append(name).append(System.lineSeparator()));
        Assert.assertEquals(rsl.toString(), expected.toString());
    }

    @Test
    public void whenChild() {
        Menu menu = new Menu();
        menu.add(0);
        menu.add(1);
        StringBuilder expected = new StringBuilder()
                .append("Задача 1.")
                .append(System.lineSeparator())
                .append("---- Задача 1.1.")
                .append(System.lineSeparator());
        StringBuilder rsl = new StringBuilder();
        menu.print().forEach(name -> rsl.append(name).append(System.lineSeparator()));
        Assert.assertEquals(rsl.toString(), expected.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenChildIllegal() {
        Menu menu = new Menu();
        menu.add(0);
        menu.add(2);
    }

    @Test
    public void whenSame() {
        Menu menu = new Menu();
        menu.add(0);
        menu.add(0);
        StringBuilder expected = new StringBuilder()
                .append("Задача 1.")
                .append(System.lineSeparator())
                .append("Задача 2.")
                .append(System.lineSeparator());
        StringBuilder rsl = new StringBuilder();
        menu.print().forEach(name -> rsl.append(name).append(System.lineSeparator()));
        Assert.assertEquals(rsl.toString(), expected.toString());
    }

    @Test
    public void whenHigh() {
        Menu menu = new Menu();
        menu.add(0);
        menu.add(1);
        menu.add(1);
        menu.add(2);
        menu.add(0);
        StringBuilder expected = new StringBuilder()
                .append("Задача 1.")
                .append(System.lineSeparator())
                .append("---- Задача 1.1.")
                .append(System.lineSeparator())
                .append("---- Задача 1.2.")
                .append(System.lineSeparator())
                .append("-------- Задача 1.2.1.")
                .append(System.lineSeparator())
                .append("Задача 2.")
                .append(System.lineSeparator());
        StringBuilder rsl = new StringBuilder();
        menu.print().forEach(name -> rsl.append(name).append(System.lineSeparator()));
        Assert.assertEquals(rsl.toString(), expected.toString());
    }


}