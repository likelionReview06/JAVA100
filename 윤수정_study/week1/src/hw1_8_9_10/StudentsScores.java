package hw1_8_9_10;

import java.util.Scanner;

//5명점수 배열에입력, 평균, 최고, 60점이상학생수 구하기
public class StudentsScores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = writeScores(sc);

        double avg = avgScores(scores);
        int max = maxScores(scores);
        int count = count60(scores);
        System.out.println("평균점수 : " + avg);
        System.out.println("최고점수 : " + max);
        System.out.println("60점 이상 학생 수 : " + count);
    }

    //입력받기
    static int[] writeScores(Scanner sc) {
        int[] arr = new int[5];
        for(int i = 0; i < arr.length; i++){
            System.out.printf("%d번 학생의 점수 : ", i+1);
            arr[i] = sc.nextInt();
            if(arr[i] < 0 || arr[i] > 100) {
                System.out.println("다시 입력하세요");
                i--;
                continue;
            }
        } return arr;
    }

    //평균 구하기
    static double avgScores(int[] scores) {
        int sum = 0;
        for(int i :  scores) sum += i;
        return (double)sum/scores.length;
    }

    //최고점수 구하기
    static int maxScores(int[] scores){
        int max = scores[0];
        for(int i = 1; i < scores.length; i++){
            if(scores[i] > max) max = scores[i];
        } return max;
    }

    //60점 이상인 학생 수 구하기
    static int count60(int[] scores) {
        int c = 0;
        for(int i : scores) {
            if(i >= 60) c++;
        } return c;

    }
}
