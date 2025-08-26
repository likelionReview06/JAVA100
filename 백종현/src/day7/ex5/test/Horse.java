package day7.ex5.test;

import day7.ex5.util.Animal;
import day7.ex5.util.IDriving;

public class Horse extends Animal implements IDriving {

    private boolean canDrive;

    public Horse(String name, int age) {
        super("말", name, age);
    }

    @Override
    public void getIn() {
        System.out.println("기수 탑승");
        canDrive = true;
    }

    @Override
    public void getOut() {
        System.out.println("기수 내림");
        canDrive = false;
    }

    @Override
    public boolean canDrive() {
        return canDrive;
    }

    @Override
    public void drive() {
        if (canDrive) {
            System.out.println("다그닥 다그닥 다그닥");
        } else {
            System.out.println("말을 몰 수 없습니다.");
        }
    }

    @Override
    public void stop() {
        System.out.println("운전 중지");
    }

    @Override
    public void cry(){
        System.out.println("이히힝");
    }

    @Override
    public void state() {
        super.state();
        System.out.println("canDrive: " + canDrive);
    }

}
