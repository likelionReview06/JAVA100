package day3;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("높이 입력: ");
        int h = sc.nextInt();


        System.out.println("-------------------");

        for (int i = 0; i < h; i++) { //직각삼각형
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("-------------------");

        for (int i = h; i > 0; i--) {//역 직각삼각형
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("-------------------");
        // 0부터 시작해서 -1 필요
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < h - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("-------------------");

        for (int i = 0; i < h; i++) {//역 삼각형
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * (h - i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
