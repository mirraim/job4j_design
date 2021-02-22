package ru.job4j.generics;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test (expected = IndexOutOfBoundsException.class)
    public void whenRemoveLastIsOutOfBounds() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(5);
        simpleArray.remove(2);
        simpleArray.get(4);
    }

    @Test
    public void whenRemove() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(5);
        simpleArray.remove(2);
        assertThat(simpleArray.get(3), is(5));
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

    @Test (expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBounds() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.set(3, 5);
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

    @Test
    public void whenItHasNext() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(2);
        simpleArray.add(3);
        Iterator<Integer> it = simpleArray.iterator();
        assertTrue(it.hasNext());
    }

    @Test
    public void whenItHasNextIsFalse() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(2);
        simpleArray.add(3);
        Iterator<Integer> it = simpleArray.iterator();
        it.next();
        it.next();
        assertFalse(it.hasNext());
    }

    @Test
    public void whenItReturnNext() {
        SimpleArray<String> simpleArray = new SimpleArray<>(5);
        simpleArray.add("2");
        simpleArray.add("3");
        Iterator<String> it = simpleArray.iterator();
        assertThat(it.next(), is("2"));
    }

    @Test
    public void whenItReturnNextWhenValueIsNull() {
        SimpleArray<String> simpleArray = new SimpleArray<>(5);
        simpleArray.add("2");
        simpleArray.add(null);
        simpleArray.add("3");
        Iterator<String> it = simpleArray.iterator();
        it.next();
        assertNull(it.next());
    }
}