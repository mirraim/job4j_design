package ru.job4j.template;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GeneratorTest {

    @Test
    public void produce() {
        Generator gen = new MyGen();
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        args.put("subject", "you");
        String rsl = gen.produce("I am a ${name}, Who are ${subject}? ", args);
        Assert.assertEquals(rsl, "I am a Petr, Who are you? ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void produceWhenLessArgs() {
        Generator gen = new MyGen();
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        String rsl = gen.produce("I am a ${name}, Who are ${subject}? ", args);
    }

    @Test
    public void produceWhenMoreArgs() {
        Generator gen = new MyGen();
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        args.put("subject", "you");
        args.put("age", "28");
        String rsl = gen.produce("I am a ${name}, Who are ${subject}? ", args);
        Assert.assertEquals(rsl, "I am a Petr, Who are you? ");
    }
}