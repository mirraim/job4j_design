package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void testRemove() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(5);
        simpleArray.remove(2);
        assertNull(simpleArray.get(4));
    }

    @Test
    public void testAdd() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(2);
        simpleArray.add(3);
        assertThat(simpleArray.get(0), is(2));
    }

    @Test
    public void testSet() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.set(0, 5);
        assertThat(simpleArray.get(0), is(5));
    }

    @Test
    public void addAfterRemove() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(5);
        simpleArray.remove(2);
        simpleArray.add(6);
        assertThat(simpleArray.get(4), is(6));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void ifArrayEnds() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(5);
        simpleArray.add(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void ifNoIndex() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.get(6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void ifRemoveNoIndex() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.remove(6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void ifSetNoIndex() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.set(4, 6);
    }
}