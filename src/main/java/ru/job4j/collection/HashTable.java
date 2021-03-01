package ru.job4j.collection;

import java.util.*;

public class HashTable<K, V> implements Iterable<K> {
    private Bucket<K, V>[] container;
    private int size = 0;
    private int modCount = 0;
    private int loadFactor;
    private int length;

    public HashTable() {

        this.container = new Bucket[16];
        this.length = 16;
        this.loadFactor = 12;
    }

    public boolean insert(K key, V value) {
        if (isEnds()) {
            container = grow();
        }
        int index = hash(key);
        if (!contains(index)) {
            container[index] = new Bucket<>(key, value);
            size++;
            modCount++;
            return true;
            }
        return false;
    }

    public V get(K key) {
        int index = hash(key);
        return container[index].value;
    }

    public boolean delete(K key) {
        int index = hash(key);
        if (contains(index)) {
            container[index] = null;
            size--;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int expectedModCount = modCount;
            private int count = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return count < size;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                for (int i = count; i < length; i++) {
                    if (container[i] != null) {
                        count++;
                        return container[i].key;
                    }
                }
                return null;
            }
        };
    }

    private int hash(K k) {
        return k == null ? 0 : k.hashCode() % length;
    }

    private boolean contains(int hash) {
        return container[hash] != null;
    }

    private boolean isEnds() {
        return size > loadFactor;
    }

    private Bucket<K, V>[] grow() {
        length = container.length * 2;
        loadFactor = length / 4 * 3;
        Bucket<K, V>[] newContainer = new Bucket[length];
        for (Bucket<K, V> kvBucket : container) {
            if (kvBucket != null) {
                int index = hash(kvBucket.key);
                newContainer[index] = kvBucket;
            }
        }
        return newContainer;
    }

    private static class Bucket<K, V> {
        K key;
        V value;

        public Bucket(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
