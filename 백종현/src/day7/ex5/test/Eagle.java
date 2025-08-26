package day7.ex5.test;

import day7.ex5.util.Animal;
import day7.ex5.util.IWings;

public class Eagle extends Animal implements IWings {

    public Eagle(String name, int age) {
        super("독수리", name, age);
    }

    @Override
    public void cry() {
        System.out.println("짹");
    }

    @Override
    public void fly() {
        System.out.println("독수리 날아갑니다.");
    }

    @Override
    public void land() {
        System.out.println("독수리 착륙합니다");
    }
}
