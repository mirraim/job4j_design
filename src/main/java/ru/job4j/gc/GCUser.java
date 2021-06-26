package ru.job4j.gc;

import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;

public class GCUser {

    public static void main(String[] args) throws InterruptedException {
        User user = new User();
        System.out.println(sizeOf(user));
        user.setId(1264);
        user.setName("N10");
        System.out.println(sizeOf(user.getName()));
        System.out.println(sizeOf(new char[2]));
        for (int i = 0; i < 8000; i++) {
           user = new User(i, "N" + i);
        }
    }
}
