package day4;

public class StaticTest {
    static int a = 10;
    int b = 20;

    public static void main(String[] args) {
        System.out.println(StaticTest.a);
        StaticTest st = new StaticTest();
        System.out.println(st.b);
    }
}
