package day7.ex6;

public interface SmartDevice {
    // 추상 메소드
    void turnOn();
    void turnOff();

    // default 메소드 (Java 8+)
    default void reset() {
        System.out.println("기본 설정으로 초기화합니다.");
        turnOff();
        turnOn();
    }

    // static 메소드 (Java 8+)
    static void showInfo() {
        System.out.println("스마트 기기 인터페이스 v1.0");
    }
}
