package day7.ex1;

import day7.ex1.util.Car;
import day7.ex1.util.IOpenRoof;

public class SuperCar extends Car implements IOpenRoof {

    private boolean roofOpen;

    public SuperCar(String color, String brand, double oilGage) {
        super(color, brand, "super car", oilGage);
    }

    public void openRoof() {
        roofOpen = true;
        System.out.println(getBrand() + ": roof is open");
    }

    public void closeRoof() {
        roofOpen = false;
        System.out.println(getBrand() + ": roof is closed");
    }

    @Override
    public void drive(int speed) {
        this.speed = speed;
        openRoof();
    }

    public void drive(int speed, boolean roofOpen) {
        this.speed = speed;
        if (roofOpen) {
            openRoof();
        }

    }

    @Override
    public void stop() {
        this.speed = 0;
        closeRoof();
    }

    public void stop(boolean closeRoof) {
        this.speed = 0;
        if (closeRoof && roofOpen) {
            closeRoof();
        }
    }

    @Override
    public void refuel(double oil) {
        this.oilGage += oil;
    }


}
