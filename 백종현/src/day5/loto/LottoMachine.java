package day5.loto;

import java.util.Random;

public class LottoMachine {
    // 1 ~ 45 당첨 번호
    private int[] lotto = new int[6];

    // 1 ~ 45 당첨 번호 나왔 는지 체크
    private boolean[] numChecker = new boolean[46];

    //2. 공 뽑기
    public void gameStart() {
        Random rand = new Random();
        int count = 0;

        while (count < 6) {
            int num = rand.nextInt(45) + 1;
            if (!numChecker[num]) {
                numChecker[num] = true;
                lotto[count] = num;
                count++;
            }
        }
    }

    // 3. 뽑기된 숫자 출력
    public void printNums() {
        for (int num : lotto) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // 4. 뽑기된 숫자 찾기
    public int[] getLotto() {
        return lotto;
    }

    // 1.리셋
    public void resetMachin(){
        for (int i = 0; i < numChecker.length; i++) numChecker[i] = false;
        for (int i = 0; i < lotto.length; i++) lotto[i] = 0;
    }
}
