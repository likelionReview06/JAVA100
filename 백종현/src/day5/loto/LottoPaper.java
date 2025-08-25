package day5.loto;

public class LottoPaper {
    private String owner;
    private int[] lotto = new int[6];

    public LottoPaper(String owner) {
        this.owner = owner;
    }

    public boolean setLotto(int ...nums) {
        if (nums.length != 6) {
            System.out.println("6개의 숫자를 입력");
            return false;
        }
        System.arraycopy(nums, 0, lotto, 0, 6);
        return true;
    }


    public String getOwner() {
        return owner;
    }

    public int[] getLotto() {
        return lotto;
    }
}
