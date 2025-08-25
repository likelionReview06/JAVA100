package day5.loto;

import java.util.ArrayList;

public class LottoGame {

    private LottoMachine lottoMachine = new LottoMachine();
    private ArrayList<LottoPaper> lottoPaper = new ArrayList<LottoPaper>();


    // 1. 게임 참여
    public void addLottoPaper(String name, int ... numbers) {
        LottoPaper paper = new LottoPaper(name);
        boolean result = paper.setLotto(numbers);

        if (!result) {
            return;
        }
        lottoPaper.add(paper);
    }

    // 2. 게임
    public void play() {
        lottoMachine.resetMachin();
        lottoMachine.gameStart();
        lottoMachine.printNums();
    }

    // 3. 맞춘 숫자 갯수 카운팅
    public int countNum(int[] lotto, LottoPaper paper) {
        int count = 0;
        for (int num : paper.getLotto()) {
            for (int i = 0; i < lotto.length; i++) {
                if (lotto[i] == num) {
                    count++;
                }
            }
        }
        return count;
    }

    // 3. 맞춘 숫자 갯수 카운팅
    public void lottoResult() {
        int[] lotto = lottoMachine.getLotto();

        for (LottoPaper paper : lottoPaper) {
            System.out.println(paper.getOwner() + ": " + countNum(lotto, paper) + " 개 맞춤");
        }
    }

    public static void main(String[] args) {

        LottoGame game = new LottoGame();

        game.addLottoPaper("A", 1, 2, 3, 4, 5, 6);
        game.addLottoPaper("B", 7, 8, 9, 10, 11, 12);
        game.addLottoPaper("C", 13, 14, 15, 16, 17, 18);
        game.addLottoPaper("D", 19, 20, 21, 22, 23, 24, 25);

        game.play();

        game.lottoResult();
    }
}
