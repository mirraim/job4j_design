package ru.job4j.tdd;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CinemaTest {
    @Ignore
    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }


    @Test (expected = IllegalArgumentException.class)
    public void buyWhenNoTickets() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        cinema.buy(account, 1, 1, date);
        cinema.buy(account, 1, 1, date);    }

    @Test (expected = IllegalArgumentException.class)
    public void buyWhenWrongDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        cinema.buy(account, -3, 1, date);
    }

    @Test (expected = IllegalArgumentException.class)
    public void buyWhenWrongPlace() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.roll(Calendar.DAY_OF_YEAR, -1);
        cinema.buy(account, 1, 1, date);
    }

    @Test(expected = IllegalStateException.class)
    public void findWhenNoSessions() {
        Cinema cinema = new Cinema3D();
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions.size(), is(0));
    }

    @Ignore
    @Test
    public void add() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions.size(), is(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addSame() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        cinema.add(session);
    }
}