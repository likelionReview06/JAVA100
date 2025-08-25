package day5.exam.e1;

public class Animal {
    final private String species;
    private String name;
    private int age;
    private double hungry;

    public Animal(String species, String name, int age) {
        this.species = species;
        this.name = name;
        this.age = age;
        hungry = 0;
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHungry() {
        return hungry;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void feed(double gage) {
        hungry += gage;
    }

}
