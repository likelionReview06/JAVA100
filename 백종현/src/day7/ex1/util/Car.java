package day7.ex1.util;

public abstract class Car {
    protected String color;
    protected String brand;
    protected String type;
    protected int speed;
    protected double oilGage;

    public Car (String color, String brand, String type, double oilGage) {
        this.color = color;
        this.brand = brand;
        this.type = type;
        this.oilGage = oilGage;
    }

    abstract protected void drive(int speed);
    abstract protected void stop();
    abstract protected void refuel(double oil);

    public String getColor() {
        return color;
    }

    public double getOilGage() {
        return oilGage;
    }

    public void setOilGage(double oilGage) {
        this.oilGage = oilGage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void state() {
        System.out.println("color: " + color);
        System.out.println("brand: " + brand);
        System.out.println("type: " + type);
        System.out.println("speed: " + speed);
        System.out.println("oilGage: " + oilGage);
    }
}
