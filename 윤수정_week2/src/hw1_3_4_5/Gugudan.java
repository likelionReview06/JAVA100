package hw1_3_4_5;

public class Gugudan {
    public static void main(String[] args) {
        Gugudan();
    }

    //static 메서드 연습, 이해
    static void Gugudan(){
        for(int i = 1; i <= 9; i++) {
            for(int j = 2; j <= 9; j++) {
                System.out.printf("%d * %d = %d\t", j, i, (i*j));
            }
            System.out.println();
        }
    }
}
