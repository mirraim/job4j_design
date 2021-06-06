package ru.job4j.gc;

public class GCUser {

    public static void main(String[] args) throws InterruptedException {
        User user = new User();
        //System.out.println(sizeOf(user));
        user.setId(1264);
        user.setName("N10");
        //System.out.println(sizeOf(user.getName()));
        //System.out.println(sizeOf(new char[2]));
        for (int i = 0; i < 8000; i++) {
            System.out.println(new User(i, "N" + i));
        }
        Thread.sleep(600);
    }
}
