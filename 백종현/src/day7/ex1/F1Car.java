package day7.ex1;

import day7.ex1.util.Car;
import day7.ex1.util.IF1;

public class F1Car extends Car implements IF1 {

    public F1Car(String color, String brand, double oilGage) {
        super(color, brand, "f1 car",  oilGage);
    }

    @Override
    public void boost() {
        this.speed += 10;
        System.out.println(getBrand() + ": " + "boost on~~~~~!");
    }

    @Override
    public void drive(int speed) {
        this.speed = speed;
    }

    @Override
    public void stop() {
        this.speed = 0;
    }

    @Override
    public void refuel(double oil) {
        this.oilGage += oil;
    }

}
