package hw1_8_9_10;

import java.util.Arrays;
import java.util.Random;

/*
로또 번호 생성기 🎲

* 1부터 45 사이의 숫자 중 중복되지 않게 6개를 랜덤으로 뽑아 배열에 저장하세요.
* 오름차순으로 정렬하여 출력하세요.
 */
public class CreateLottoNumber {
    public static void main(String[] args) {
        Random rand = new Random();

        int[] nums = new int[6];

        //중복없이 랜덤하게 숫자 뽑기
        for(int i = 0; i < nums.length; i++){
            boolean yn = false;
            nums[i] = rand.nextInt(45) + 1;

            //방금 뽑은 i번째 인덱스값 검사
            for(int j = 0; j < i; j++){
                if(nums[j] == nums[i]) {
                    yn = true;
                    break;
                }
            }

            if(yn) i--; //전 루프로 되돌림
        }

        //오름차순 정렬
        Arrays.sort(nums);
        System.out.println("생성된 6개 로또게임 숫자들 : " + Arrays.toString(nums));
    }
}

