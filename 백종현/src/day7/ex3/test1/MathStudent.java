package day7.ex3.test1;

import day7.ex3.util.IStudent;
import day7.ex3.util.Person;

public class MathStudent extends Person implements IStudent {
    private int score;

    public MathStudent(String name, int age, String gender) {
        super(name, age, gender);
        this.job = "MathStudent";
        this.score = 0;
    }

    @Override
    public void study(int hour) {
        System.out.println(getName() + ": MathStudent is studying");
        this.score += hour;
    }

    @Override
    public void play(int hour) {
        System.out.println(getName() + ": MathStudent is playing");
        this.score -= hour;
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public void work() {
        System.out.println(getName() + ": MathStudent is working");
        this.study(1);
    }

    @Override
    public void state() {
        super.state();
        System.out.println("score: " + score);
    }

}
