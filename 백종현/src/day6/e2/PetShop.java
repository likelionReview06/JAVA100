package day6.e2;

import day5.exam.e1.Animal;
import day5.exam.e1.Zoo;

public class PetShop extends Zoo {

    void addPet(String species, String name, int age, String master, String howl) {
        Pet pet = new Pet(species, name, age, master, howl);
        addAnimal(pet); //업 케스팅
    }

    public static void main(String[] args) {
        PetShop petShop = new PetShop();

        petShop.addPet("고양이", "나비", 4, "백종현", "야옹");
        petShop.addPet("강아지", "멍구", 5, "백종현", "왈");
        petShop.addPet("하마", "마마", 8, "백종현", "하마아아아");

        Animal fish = new Animal("금붕어", "금붕이", 1);
        petShop.addAnimal(fish);

        petShop.printAnimalList();

        petShop.feedAnimal("고양이", "나비", 1.5);

        petShop.feedAnimal(1.5);

        petShop.printAnimalList();
    }

}
