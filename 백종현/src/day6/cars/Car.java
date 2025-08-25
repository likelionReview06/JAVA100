package day6.cars;

public class Car {
    private double fuel;
    private int distance;
    private boolean [] seats;
    private int speed;
    private String color;

    public Car(int seats, String color) {
        this.seats = new boolean[seats];
        this.color = color;
        this.fuel = 100;
        this.distance = 0;
        this.speed = 0;
    }

    public void drive(int distance, int speed) {
        this.distance += distance;
        this.fuel -= distance * 0.1;
        this.speed = speed;
    }

    public void stop() {
        this.speed = 0;
    }

    public void refuel(double fuel) {
        this.fuel += fuel;
    }

    public double getFuel() {
        return this.fuel;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getSpeed() {
        return this.speed;
    }

    public String getColor() {
        return this.color;
    }

    public boolean[] getSeats() {
        return this.seats;
    }

    public void setColor(String color){
        this.color = color;
    }
}
