package day7.ex5.test;

import day7.ex5.util.IDriving;
import day7.ex5.util.IWings;
import day7.ex5.util.Machine;

public class Airplane extends Machine implements IWings, IDriving {
    public boolean canDrive;

    public Airplane(String type) {
        super(type);
        this.canDrive = false;
    }

    @Override
    public void state() {
        super.state();
        System.out.println("canDrive: " + canDrive);
    }

    @Override
    public void refuel(double gage) {
        gasGage += gage;
    }

    @Override
    public void getIn() {
        System.out.println("조종사 탑승");
        canDrive = true;
    }

    @Override
    public void getOut() {
        System.out.println("조종사 내림");
        canDrive = false;
    }

    @Override
    public void drive() {
        if (canDrive) {
            fly();
            System.out.println("비행 시작");
        } else {
            System.out.println("비행기를 운전할 수 없습니다.");
        }
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean canDrive() {
        return canDrive;
    }

    @Override
    public void fly() {
        System.out.println("비행기 날아갑니다.");
    }

    @Override
    public void land() {
        System.out.println("비행기 착륙합니다");
    }
}
