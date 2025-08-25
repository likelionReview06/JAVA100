package day4;

public class Wallet {
    private String owner;

    private int bill1000;
    private int bill10000;
    private int bill50000;

    public Wallet(String owner) {
        this.owner = owner;
    }

    public Wallet(String owner, int bill1000, int bill10000, int bill50000) {
        this.owner = owner;
        this.bill1000 = bill1000;
        this.bill10000 = bill10000;
        this.bill50000 = bill50000;
    }

    public void getStatus() {
        System.out.println("=========지갑 사정=========");
        System.out.println("주인 : " + owner);
        System.out.println("1000원권 : " + bill1000);
        System.out.println("10000원권 : " + bill10000);
        System.out.println("50000원권 : " + bill50000);
        System.out.println("총액: " + (bill1000 * 1000 + bill10000 * 10000 + bill50000 * 50000));
        System.out.println("=========지갑 사정=========");
        System.out.println();
    }

    public void getStatus(int bill) {
        switch (bill) {
            case 1000:
                System.out.println("1000원권 : " + bill1000);
                break;
            case 10000:
                System.out.println("10000원권 : " + bill10000);
                break;
            case 50000:
                System.out.println("50000원권 : " + bill50000);
                break;
        }
    }

    public void addBill(int bill, int count) {
        switch (bill) {
            case 1000:
                bill1000 += count;
                break;
            case 10000:
                bill10000 += count;
                break;
            case 50000:
                bill50000 += count;
                break;
        }
    }

    public void popBill(int bill, int count) {
        switch (bill) {
            case 1000:
                if (bill1000 < count) return;
                bill1000 -= count;
                break;
            case 10000:
                if (bill10000 < count) return;
                bill10000 -= count;
                break;
            case 50000:
                if (bill50000 < count) return;
                bill50000 -= count;
                break;
        }
    }

    public static void main(String[] args) {

        Wallet w1 = new Wallet("백종현", 10, 5, 1);
        w1.getStatus();
        w1.getStatus(1000);
        w1.addBill(1000, 5);
        w1.getStatus(1000);
        w1.popBill(1000, 5);
        w1.getStatus(1000);

    }

}
