package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LinkedArrayTest {
    @Test
    public void whenAddThenGet() {
        LinkedArray<String> array = new LinkedArray<>();
        array.add("first");
        String rsl = array.get(0);
        assertThat(rsl, is("first"));
    }

    @Test
    public void whenCreate0LengthThenAdd() {
        LinkedArray<String> array = new LinkedArray<>();
        array.add("first");
        String rsl = array.get(0);
        assertThat(rsl, is("first"));
    }

    @Test
    public void whenCreate1LengthThenAdd() {
        LinkedArray<String> array = new LinkedArray<>();
        array.add("first");
        array.add("Second");
        String rsl = array.get(1);
        assertThat(rsl, is("Second"));
    }

    @Test
    public void whenAddThenIt() {
        LinkedArray<String> array = new LinkedArray<>();
        array.add("first");
        String rsl = array.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        LinkedArray<String> array = new LinkedArray<>();
        array.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        LinkedArray<String> array = new LinkedArray<>();
        array.add("first");
        array.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        LinkedArray<String> array = new LinkedArray<>();
        array.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        LinkedArray<String> array = new LinkedArray<>();
        array.add("first");
        Iterator<String> it = array.iterator();
        array.add("second");
        it.next();
    }
}