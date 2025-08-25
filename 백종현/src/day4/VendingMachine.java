package day4;

public class VendingMachine {
    private int capacity;
    private String [] drinks;
    private int [] prices;
    private int [] quantities;


    public VendingMachine(int capacity) {
        this.capacity = capacity;
        this.drinks = new String[capacity];
        this.prices = new int[capacity];
        this.quantities = new int[capacity];
    }

    public void addDrink(String drink, int price, int quantity) {
        for (int i = 0; i < capacity; i++) {
            if (drinks[i] == null) {
                drinks[i] = drink;
                prices[i] = price;
                quantities[i] = quantity;
                break;
            }
        }
    }

    public void addDrink(String drink, int quantity) {
        for (int i = 0; i < capacity; i++) {
            if (drinks[i] == drink) {
                quantities[i] += quantity;
                System.out.println("수정된 수량 : " + quantities[i]);
                break;
            }
        }
    }

    public int buy(String drink, int money) {
        int change = 0;
        for (int i = 0; i < capacity; i++) {
            if (drinks[i] == drink) {
                if (prices[i] <= money) {
                    change = money - prices[i];
                    quantities[i] -= 1;
                    System.out.println("구매품: " + drink);
                    System.out.println("잔돈 :" + change);
                    break;
                } else {
                    System.out.println("돈 부족");
                }
            }
        }
        return change;

    }

    public void getStatus() {
        System.out.println("\n=========자판기 현황=========\n");

        for (int i = 0; i < capacity; i++) {
            System.out.println(drinks[i] + " : " + quantities[i]);
            System.out.println("price" + " : " + prices[i] + "\n");
        }

        System.out.println("=========자판기 현황=========\n");
    }

    public void getStatus(String drink) {
        System.out.println("\n=========자판기 현황=========\n");

        for (int i = 0; i < capacity; i++) {
            if (drinks[i] == drink) {
                System.out.println(drinks[i] + " : " + quantities[i]);
                System.out.println("price" + " : " + prices[i] + "\n");
            }
        }

        System.out.println("=========자판기 현황=========\n");
    }

    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine(3);
        vm.addDrink("콜라", 1000, 5);
        vm.addDrink("사이다", 1000, 5);
        vm.addDrink("환타", 1000, 5);
        vm.getStatus();
        vm.buy("환타", 2000);

        vm.getStatus("환타");
    }


}