package hw1_1_2;

import java.util.Scanner;

public class CheckOddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OddEven(sc);
    }

    static void OddEven(Scanner sc) {
        System.out.print("홀수짝수 판별할 정수를 입력하세요 : ");
        int a = sc.nextInt();
        if(a%2 == 0) System.out.printf("%d는 짝수\n", a);
        else if(a%2 == 1) System.out.printf("%d는 홀수\n" + a);
        else System.out.println("0은 안됩니다");
    }
}
