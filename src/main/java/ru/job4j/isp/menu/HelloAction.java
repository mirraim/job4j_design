package ru.job4j.isp.menu;

public class HelloAction implements Action {
    @Override
    public void execute() {
        System.out.println("Hello!");
    }
}
