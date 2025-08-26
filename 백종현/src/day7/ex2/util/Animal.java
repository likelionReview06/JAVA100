package day7.ex2.util;

public abstract class Animal {
    protected String species;
    protected String name;
    protected int age;
    protected double hungry;

    abstract protected void feed(double gage);
    abstract protected void makeNoise();
    abstract protected void state();
}


