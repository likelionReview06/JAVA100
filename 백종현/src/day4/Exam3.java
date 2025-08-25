package day4;

import java.util.Arrays;

public class Exam3 {


    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5, 6, 7};
        int[] reversed = new int[original.length];

        int i = original.length - 1;
        for (int n : original) {
            reversed[i] = n;
            i--;
        }

        System.out.println("원본: " + Arrays.toString(original));
        System.out.println("뒤집기: " + Arrays.toString(reversed));
    }
}
