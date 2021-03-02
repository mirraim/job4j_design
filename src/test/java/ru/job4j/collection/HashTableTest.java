package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class HashTableTest {

    @Test
    public void whenInsert() {
        HashTable<Integer, String> table = new HashTable<>();
        table.insert(23, "first");
        table.insert(56, "second");
        Iterator<Integer> it = table.iterator();
        it.next();
        assertTrue(it.hasNext());
        assertTrue(it.hasNext());
    }

    @Test
    public void whenInsertEqualsThenIter() {
        HashTable<Integer, String> table = new HashTable<>();
        table.insert(23, "first");
        table.insert(23, "second");
        Iterator<Integer> it = table.iterator();
        it.next();
        assertFalse(it.hasNext());
    }

    @Test
    public void whenInsertEquals() {
        HashTable<Integer, String> table = new HashTable<>();
        table.insert(23, "first");
        table.insert(23, "second");
        assertEquals(table.get(23), "second");
    }
    @Test
    public void whenInsertDifferentButSameHash() {
        HashTable<User, String> table = new HashTable<>();
        table.insert(new User("anna", 2), "first");
        assertFalse(table.insert(new User("anna", 0), "second"));

    }

    @Test
    public void whenGet() {
        HashTable<Integer, String> table = new HashTable<>();
        table.insert(23, "first");
        table.insert(56, "second");
        assertEquals(table.get(56), "second");
    }

    @Test
    public void whenGrow() {
        HashTable<Integer, String> table = new HashTable<>();
        table.insert(23, "first");
        table.insert(56, "second");
        table.insert(1, "first");
        table.insert(2, "second");
        table.insert(3, "first");
        table.insert(4, "second");
        table.insert(5, "first");
        table.insert(6, "second");
        table.insert(7, "first");
        table.insert(8, "second");
        table.insert(9, "first");
        table.insert(10, "second");
        table.insert(11, "first");
        table.insert(12, "second");
        assertEquals(table.get(10), "second");
    }

    @Test
    public void whenDelete() {
        HashTable<User, String> table = new HashTable<>();
        table.insert(new User("anna", 2), "first");
        table.insert(new User("tom", 0), "second");
        assertFalse(table.delete(new User("anna", 0)));
    }

    @Test
    public void whenDeleteNotEquals() {
        HashTable<Integer, String> table = new HashTable<>();
        table.insert(23, "first");
        table.insert(56, "second");
        table.delete(56);
        Iterator<Integer> it = table.iterator();
        it.next();
        assertFalse(it.hasNext());
    }

    @Test
    public void whenDeleteIncorrect() {
        HashTable<Integer, String> table = new HashTable<>();
        table.insert(23, "first");
        table.insert(56, "second");
        assertFalse(table.delete(14));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddThenDelete() {
        HashTable<Integer, String> table = new HashTable<>();
        table.insert(23, "first");
        table.insert(56, "second");
        Iterator<Integer> it = table.iterator();
        table.delete(56);
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmpty() {
        HashTable<Integer, String> table = new HashTable<>();
        Iterator<Integer> it = table.iterator();
        it.next();
    }

}