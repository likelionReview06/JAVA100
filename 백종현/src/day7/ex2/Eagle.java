package day7.ex2;

import day7.ex2.util.Animal;
import day7.ex2.util.Ibird;

public class Eagle extends Animal implements Ibird {
    public int aggNum = 0;
    public Eagle(String name, int age) {
        this.species = "독수리";
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
        System.out.println("독수리 : " + name + " (" + age + ")");
        System.out.println("허기 : " + hungry + "\n");
    }
    @Override
    public void state() {
        System.out.println("독수리 : " + name + " (" + age + ")");
        System.out.println("허기 : " + hungry + "\n");
    }
    @Override
    public void fly() {
        System.out.println(species + "가 날아갑니다.");
    }
    @Override
    public void makeAgg() {
        System.out.println(species + "가 알을 낳습니다.");
        aggNum++;
    }
    @Override
    public void printAggNum(){
        System.out.println(species + "의 알의 수 : " + aggNum);
    }
}
