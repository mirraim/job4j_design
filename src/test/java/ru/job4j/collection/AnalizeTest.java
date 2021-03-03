package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void whenDiff() {
        Analize analize = new Analize();
        List<Analize.User> previous = List.of(

        );

        List<Analize.User> current = List.of(
                new Analize.User(1, "Anny")
        );
        Analize.Info info = analize.diff(previous, current);

        assertThat(new int[]{info.added, info.deleted, info.changed},
                is(new int[]{1, 0, 0}));
    }

    @Test
    public void whenEmpty() {
        Analize analize = new Analize();
        List<Analize.User> previous = new ArrayList<>();
        List<Analize.User> current = new ArrayList<>();
        Analize.Info info = analize.diff(previous, current);

        assertThat(new int[]{info.added, info.deleted, info.changed},
                is(new int[]{0, 0, 0}));
    }

    @Test
    public void whenDelete() {
        Analize analize = new Analize();
        List<Analize.User> previous = List.of(
                new Analize.User(3, "Jane")
        );

        List<Analize.User> current = List.of(
        );
        Analize.Info info = analize.diff(previous, current);

        assertThat(new int[]{info.added, info.deleted, info.changed},
                is(new int[]{0, 1, 0}));
    }

    @Test
    public void whenChange() {
        Analize analize = new Analize();
        List<Analize.User> previous = List.of(
                new Analize.User(3, "Jane")
        );

        List<Analize.User> current = List.of(
                new Analize.User(3, "Inna")
        );
        Analize.Info info = analize.diff(previous, current);

        assertThat(new int[]{info.added, info.deleted, info.changed},
                is(new int[]{0, 0, 1}));
    }

    @Test
    public void whenAddAndDeletedAndChange() {
        Analize analize = new Analize();
        List<Analize.User> previous = List.of(
                new Analize.User(1, "Anny"),
                new Analize.User(2, "Sarah"),
                new Analize.User(3, "Jane")
        );

        List<Analize.User> current = List.of(
                new Analize.User(1, "Anny"),
                new Analize.User(4, "Jane"),
                new Analize.User(3, "Inna")
        );
        Analize.Info info = analize.diff(previous, current);

        assertThat(new int[]{info.added, info.deleted, info.changed},
                is(new int[]{1, 1, 1}));
    }
}