package day6.e2;

import day5.exam.e1.Animal;

public class Pet extends Animal {

    public String master;
    public String howl;

    public Pet(String species, String name, int age, String master, String howl) {
        super(species, name, age); //부모 생성자 호출
        this.master = master;
        this.howl = howl;
    }

    public String getMaster() {
        return master;
    }

    public void howling() {
        System.out.println(getName() + ": " + howl + "~~~ \n");
    }

    // 오버 라이딩
    @Override
    public void feed(double gage) {
        super.feed(gage);
        System.out.println(getName() + ": " + howl + "~~~ \n");
    }

}
