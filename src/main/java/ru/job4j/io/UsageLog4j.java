package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        char gender = 'm';
        double height = 1.78;
        float weight = 81.600f;
        long id = 14569872364L;
        boolean isMarried = false;
        short children = 0;
        LOG.debug("User info name : {}, age : {}, gender : {}, height : {}, weight : {}, id : {}, isMarried : {}, children : {}",
                name, age, gender, height, weight, id, isMarried, children);
    }
}
