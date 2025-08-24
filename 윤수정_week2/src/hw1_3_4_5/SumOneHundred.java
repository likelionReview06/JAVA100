package hw1_3_4_5;

public class SumOneHundred {
    public static void main(String[] args) {
        System.out.println("1~100까지의 합 : " + getSum());
    }

    //static 메서드 연습, 이해
    static int getSum(){
        int sum = 0;
        for(int i = 1 ; i <= 100; i++) {
            sum += i;
        } return sum;
    }
}
