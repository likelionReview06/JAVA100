package hw1_8_9_10;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    //main메서드만 사용해보기
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int answer = rand.nextInt(100) + 1;
        int num = 0;

        //입력, 비교
        while (true) {
            System.out.print("1~100까지의 숫자를 입력해주세요 : ");
            num = sc.nextInt();

            if (num < 1 || num > 100) {
                System.out.println("다시 입력하세요.");
                continue; //처음부터 반복 다시시작
            }

            if (num > answer) {
                System.out.println("더 작은 수를 입력하세요.");
            } else if (num < answer) {
                System.out.println("더 큰 수를 입력하세요.");
            } else {
                System.out.println("정답입니다!");
                break;
            }
        }
    }
}

