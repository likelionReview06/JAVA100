package day7.ex5.test;

import day7.ex5.util.Animal;
import day7.ex5.util.IDriving;
import day7.ex5.util.IWings;
import day7.ex5.util.Machine;

public class Test {
    public static void main(String[] args) {
        //일단 다 담어
        Object []o = new Object[3];
        o[0] = new Eagle("독수리", 10);
        o[1] = new Horse("말", 20);
        o[2] = new Airplane("비행기");


        System.out.println("=============state============");
        //각자 다른 추상 클래스를 상속 받았기에 거기에 맞는 메서드를 사용
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
        //말과 비행기는 다른 클래스를 상속 받았지만 같은 인터페이스를 임프리먼트 하기때문에 동작함
        for (Object obj : o) {
            System.out.println();
            if (obj instanceof IDriving){
                ((IDriving)obj).drive();
                System.out.println("-----------------------------");
            }
        }

        System.out.println("=============fly============");
        //독수리와 비행기는 다른 클래스를 상속 받았지만 같은 인터페이스를 임프리먼트 하기때문에 동작함
        for (Object obj : o) {
            System.out.println();
            if (obj instanceof IWings) {
                ((IWings) obj).fly();
                System.out.println("-----------------------------");
            }
        }
    }
}
