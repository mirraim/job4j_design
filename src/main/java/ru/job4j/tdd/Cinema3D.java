package ru.job4j.tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class Cinema3D implements Cinema {
    @Override
    public List<Session> find(Predicate<Session> filter) {
        throw new IllegalStateException();
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        throw new IllegalArgumentException();
    }

    @Override
    public void add(Session session) {
        throw new IllegalArgumentException();
    }
}
