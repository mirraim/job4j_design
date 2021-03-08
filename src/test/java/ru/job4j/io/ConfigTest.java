package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Petr Arsentev")
        );
    }

    @Test
    public void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
               config.getKeys().size(),
                is(1)
        );
    }

    @Test
    public void whenNotFound() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("some"),
                is("")
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairNotValid() {
        String path = "./data/pair_invalid.properties";
        Config config = new Config(path);
        config.load();
    }
}