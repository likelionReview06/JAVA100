package day7.ex5.test;

import day7.ex5.util.Animal;
import day7.ex5.util.IDriving;
import day7.ex5.util.IWings;
import day7.ex5.util.Machine;

public class Test {
    public static void main(String[] args) {
        Object []o = new Object[3];
        o[0] = new Eagle("독수리", 10);
        o[1] = new Horse("말", 20);
        o[2] = new Airplane("비행기");


        System.out.println("=============state============");
        for (Object obj : o) {
            System.out.println();
            if (obj instanceof Animal)
                ((Animal)obj).state();
            else if (obj instanceof Machine)
                ((Machine)obj).state();
            System.out.println("-----------------------------");
        }

        System.out.println("=============cry============");
        for (Object obj : o) {
            System.out.println();
            if (obj instanceof Animal) {
                ((Animal) obj).cry();
                System.out.println("-----------------------------");
            }
        }

        System.out.println("=============drive============");
        for (Object obj : o) {
            System.out.println();
            if (obj instanceof IDriving){
                ((IDriving)obj).drive();
                System.out.println("-----------------------------");
            }
        }

        System.out.println("=============fly============");
        for (Object obj : o) {
            System.out.println();
            if (obj instanceof IWings) {
                ((IWings) obj).fly();
                System.out.println("-----------------------------");
            }
        }
    }
}
