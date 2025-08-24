package hw1_1_2;

import java.util.Scanner;

public class MaxCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        maxCompare(sc);
    }

    static void maxCompare(Scanner sc) {
        System.out.print("a 입력 : ");
        int a = sc.nextInt();
        System.out.print("b 입력 : ");
        int b = sc.nextInt();
        System.out.print("c 입력 : ");
        int c = sc.nextInt();

        if(a == b && b == c) System.out.println("똑같습니다");
        else if(a > b && a > c) System.out.println("가장 큰 수 : " + a);
        else if(b > a && b > c) System.out.println("가장 큰 수 : " + b);
        else System.out.println("가장 큰 수 : " + c);
    }
}
