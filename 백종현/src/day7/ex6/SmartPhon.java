package day7.ex6;

public class SmartPhon implements SmartDevice{

    String phoneNumber;

    public SmartPhon(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public void turnOn() {
        System.out.println("스마트폰 켜짐");
    }

    @Override
    public void turnOff() {
        System.out.println("스마트폰 꺼짐");
    }

    @Override
    public void reset() {
        System.out.println("기본 설정으로 초기화");
        turnOff();
        turnOn();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
