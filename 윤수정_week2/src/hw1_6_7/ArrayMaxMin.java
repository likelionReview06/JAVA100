package hw1_6_7;

import java.util.Scanner;

public class ArrayMaxMin {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nums [] = writeNums(sc);
        checkMaxMin(nums);
    }

    //정수 5개 입력받기
    static int[] writeNums(Scanner sc){
        int[] nums = new int[5];
        System.out.println("정수 5개를 입력하세요 : ");
        for(int i = 0; i < nums.length; i++){
            nums[i] = sc.nextInt();
        }
        return nums;
    }

    //nums중 최소, 최대 구하기
    static void checkMaxMin(int[] nums) {
        int max = nums[0];
        int min = nums[0];

        for(int i = 0; i < nums.length; i++){
            //최댓값 구하기
            if(nums[i] > max){
                max = nums[i];
            }
            //최솟값 구하기
            if(nums[i] < min){
                min = nums[i];
            }
        }
        System.out.printf("최댓값 : %d / 최솟값 : %d", max, min);
    }

}
