package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value, null);
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    public void revert() {
        if (head != null) {
            Node<T> current = head;
            Node<T> nextNode;
            Node<T> prev = null;
            while (current.next != null) {
                nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }
            current.next = prev;
            head = current;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> temp = head;
        head = temp.next;
        temp.next = null;
        return temp.value;
    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> current = head;
        if (head.next == null) {
            head = null;
            return current.value;
        }
        while (current.next.next != null) {
            current = current.next;
        }
        Node<T> temp = current.next;
        current.next = null;
        return temp.value;
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
