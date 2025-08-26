package day7.ex5.util;

public abstract class Animal {
    protected String species;
    protected String name;
    protected int age;


    public Animal(String species, String name, int age) {
        this.species = species;
        this.name = name;
        this.age = age;
    }

    public void state() {
        System.out.println("종류: " + species);
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
    }

    public abstract void cry();
}
