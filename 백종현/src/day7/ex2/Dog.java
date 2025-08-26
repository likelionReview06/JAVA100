package day7.ex2;

import day7.ex2.util.Animal;

public class Dog extends Animal {
    public Dog(String name, int age) {
        this.species = "개";
        this.name = name;
        this.age = age;
        this.hungry = 0;
    }

    @Override
    public void feed(double gage) {
        hungry += gage;
    }

    @Override
    public void makeNoise() {
        System.out.println("멍멍");
    }

    @Override
    public void state() {
        System.out.println("개 : " + name + " (" + age + ")");
        System.out.println("허기 : " + hungry + "\n");
    }
}
