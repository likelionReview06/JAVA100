package day4;

import java.util.Arrays;

public class Exam2 {
    public static void main(String[] args) {
        int[] numbers = {23, 56, 12, 89, 34, 67, 45, 78, 90, 11};

        int min = Arrays.stream(numbers).min().getAsInt();
        int max = Arrays.stream(numbers).max().getAsInt();


        System.out.println("numbers : " + Arrays.toString(numbers));
        System.out.println("min : " + min);
        System.out.println("max : " + max);
    }
}
