package ru.job4j.isp.menu;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class MenuTest {

    @Test(expected = IllegalArgumentException.class)
    public void addIllegal() {
        Menu menu = new Menu();
        menu.add("First");
        menu.add("Second", "First");
    }

    @Test
    public void whenFirst() {
        Menu menu = new Menu();
        menu.add("First");
        StringBuilder expected = new StringBuilder()
                .append("1. First")
                .append(System.lineSeparator());
        Assert.assertEquals(menu.print(), expected.toString());
    }

    @Test
    public void whenChild() {
        Menu menu = new Menu();
        menu.add("First");
        menu.add("First", "Second");
        StringBuilder expected = new StringBuilder()
                .append("1. First")
                .append(System.lineSeparator())
                .append("  1.1. Second")
                .append(System.lineSeparator());
        Assert.assertEquals(menu.print(), expected.toString());
    }

    @Test
    public void whenSame() {
        Menu menu = new Menu();
        menu.add("First");
        menu.add("Second");
        StringBuilder expected = new StringBuilder()
                .append("1. First")
                .append(System.lineSeparator())
                .append("2. Second")
                .append(System.lineSeparator());
        Assert.assertEquals(menu.print(), expected.toString());
    }

    @Test
    public void whenManyCild() {
        Menu menu = new Menu();
        menu.add("First");
        menu.add("Second");
        menu.add("First", "Third");
        menu.add("Third", "Fourth", new HelloAction());
        menu.add("First", "Five");
        StringBuilder expected = new StringBuilder()
                .append("1. First")
                .append(System.lineSeparator())
                .append("  1.1. Third")
                .append(System.lineSeparator())
                .append("    1.1.1. Fourth")
                .append(System.lineSeparator())
                .append("  1.2. Five")
                .append(System.lineSeparator())
                .append("2. Second")
                .append(System.lineSeparator());
        Assert.assertEquals(menu.print(), expected.toString());
    }

    @Test
    public void whenChooseIllegal() {
        Menu menu = new Menu();
        menu.add("First");
        Assert.assertFalse(menu.choose("First"));
    }

    @Ignore
    @Test
    public void whenChoose() {
        Menu menu = new Menu();
        menu.add("First", new HelloAction());
        Assert.assertTrue(menu.choose("First"));
    }
}