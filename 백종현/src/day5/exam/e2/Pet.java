package day5.exam.e2;

import day5.exam.e1.Animal;

public class Pet extends Animal {

    public String master;
    public String howl;

    public Pet(String species, String name, int age, String master, String howl) {
        super(species, name, age);
        this.master = master;
        this.howl = howl;
    }

    public String getMaster() {
        return master;
    }

    public void howling() {
        System.out.println(getName() + ": " + howl + "~~~ \n");
    }

    @Override
    public void feed(double gage) {
        super.feed(gage);
        System.out.println(getName() + ": " + howl + "~~~ \n");
    }

}
