package day7.ex1;

import day7.ex1.util.Car;
import day7.ex1.util.IF1;
import day7.ex1.util.IOpenRoof;

public class CarTest {
    public static void main(String[] args) {
        Car superCar = new SuperCar("red", "bmw", 100);
        Car f1Car = new F1Car("blue", "ferrari", 100);
        IF1 f1 = new F1Car("yellow", "redbull", 100);
        IOpenRoof openRoof = new SuperCar("green", "audi", 100);

        if(f1 instanceof Car){
            ((Car)f1).state();
        }

        System.out.println("\n----------------\n");

        if(openRoof instanceof Car){
            ((Car)openRoof).state();
        }

        System.out.println("\n----------------\n");

        if(superCar instanceof IOpenRoof){
            ((IOpenRoof)superCar).openRoof();
        }

        System.out.println("\n----------------\n");

        if(f1Car instanceof IF1){
            ((IF1)f1).boost();
        }
    }
}
