package day5.exam.e1;

import java.util.ArrayList;

public class Zoo {
    private final ArrayList<Animal> animalList;

    public Zoo() {
        animalList = new ArrayList<Animal>();
    }

    public void addAnimal(String species, String name, int age) {
        Animal animal = new Animal(species, name, age);
        animalList.add(animal);
    }

    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    public void printAnimalList() {
        System.out.println("\n----------Animal List-----------\n");
        for (Animal animal : animalList) {
            System.out.println(animal.getSpecies() + " : " + animal.getName() + " (" + animal.getAge() + ")");
            System.out.println("Hungry : " + animal.getHungry() + "\n");
        }
        System.out.println("----------Animal List-----------\n");
    }

    public void feedAnimal(String species, String name, double gage) {
        for (Animal animal : animalList) {
            if (animal.getSpecies().equals(species) && animal.getName().equals(name)) {
                animal.feed(gage);
            }
        }
    }

    public void feedAnimal(double gage) {
        for (Animal animal : animalList) {
            animal.feed(gage);
        }
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.addAnimal("고양이", "나비", 4);
        zoo.addAnimal("사자", "라이온", 5);
        Animal hipo = new Animal("하마", "마마", 8);
        zoo.addAnimal(hipo);

        zoo.printAnimalList();

        zoo.feedAnimal("고양이", "나비", 1.5);
        zoo.printAnimalList();

        zoo.feedAnimal(1.5);
        zoo.printAnimalList();
    }
}
