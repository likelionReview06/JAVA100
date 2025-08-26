package day7.designPattern;

abstract class testObject {
    public abstract void print();
}

class testObject1 extends testObject{
    @Override
    public void print() {
        System.out.println("testObject1");
    }
}

class testObject2 extends testObject{
    @Override
    public void print() {
        System.out.println("testObject2");
    }
}

class testObject3 extends testObject{
    @Override
    public void print() {
        System.out.println("testObject3");
    }
}

public class FactoryTest {
    static testObject createObject(int type) {
        switch (type) {
            case 1:
                return new testObject1();
            case 2:
                return new testObject2();
            case 3:
                return new testObject3();
            default:
                return null;
        }
    }
}

class FTest {
    public static void main(String[] args) {
        for(int i = 1; i < 4; i++) {
            FactoryTest.createObject(i).print();
        }
    }
}