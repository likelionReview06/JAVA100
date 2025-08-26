package day7.ex6;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Smartwatch implements SmartDevice{
    private boolean isOn;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("스마트워치 켜짐");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("스마트워치 꺼짐");
    }

    @Override
    public void reset() {
        turnOff();
        turnOn();
    }

    public void whatTimeIsIt() {
        if (!isOn) {
            System.out.println("스마트워치가 켜져있지 않습니다.");
            return;
        }
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String time = now.format(formatter);
        System.out.println("현재 시간은 " + time + "입니다.");
    }

    public static void main(String[] args) {
        Smartwatch smartwatch = new Smartwatch();
        smartwatch.turnOn();
        smartwatch.whatTimeIsIt();
        smartwatch.turnOff();
    }
}
