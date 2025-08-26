package day7.ex2;

import day7.ex2.util.Animal;

public class Cat extends Animal {
    public Cat(String name, int age) {
        this.species = "고양이";
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
        System.out.println("야옹");
    }

    @Override
    public void state() {
        System.out.println("고양이 : " + name + " (" + age + ")");
        System.out.println("허기 : " + hungry + "\n");
    }
}