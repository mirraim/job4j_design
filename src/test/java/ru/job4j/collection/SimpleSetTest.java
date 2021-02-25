package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class SimpleSetTest {

    @Test
    public void whenAdd() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("one");
        set.add("two");
        set.add("one");
        Iterator<String> it = set.iterator();
        it.next();
        it.next();
        assertFalse(it.hasNext());
    }

    @Test
    public void whenAddNull() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("one");
        set.add("two");
        set.add(null);
        Iterator<String> it = set.iterator();
        it.next();
        it.next();
        assertNull(it.next());
    }

    @Test
    public void whenAddTwoNull() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("one");
        set.add(null);
        set.add(null);
        Iterator<String> it = set.iterator();
        it.next();
        it.next();
        assertFalse(it.hasNext());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddIterThenAdd() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("one");
        set.add("two");
        Iterator<String> it = set.iterator();
        set.add(null);
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmpty() {
        SimpleSet<String> set = new SimpleSet<>();
        Iterator<String> it = set.iterator();
        it.next();
    }
}