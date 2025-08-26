package day7.designPattern;

public class SingletonTest {
    private static SingletonTest instance;

    private SingletonTest() {

    }

    public static SingletonTest getInstance() {
        if(instance == null) {
            instance = new SingletonTest();
        }
        return instance;
    }

    public void print() {
        System.out.println("싱글톤 테스트");
    }
}

class STest {
    public static void main(String[] args) {
        SingletonTest.getInstance().print();
    }
}
