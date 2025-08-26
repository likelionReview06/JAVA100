package day7.ex5.util;

public abstract class Machine {
    protected String type;
    protected boolean isRunning;
    protected double gasGage;

    public Machine(String type) {
        this.type = type;
        this.isRunning = false;
    }

    public abstract void refuel(double gage);

    public void state() {
        System.out.println("type: " + type);
        System.out.println("isRunning: " + isRunning);
        System.out.println("gasGage: " + gasGage);
    }
}
