import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class StoreManager {
    private int totalAsset;
    private List<Transaction> transactionLog;
    private HashMap<Integer, Table> tables;
    private HashMap<String, MenuItem> menu; // menu 변수 선언 추가

    public StoreManager() {
        this.totalAsset = 0;
        this.transactionLog = new ArrayList<>();
        this.tables = new HashMap<>();
        this.menu = new HashMap<>(); // HashMap 객체 생성
        initializeMenu();
    }

    private void initializeMenu() {
        menu.put("밥", new MenuItem("밥", 8000, "음식"));
        menu.put("면", new MenuItem("면", 9000, "음식"));
        menu.put("요리", new MenuItem("요리", 25000, "음식"));
        menu.put("콜라", new MenuItem("콜라", 2000, "음료"));
        menu.put("사이다", new MenuItem("사이다", 2000, "음료"));
        menu.put("소주", new MenuItem("소주", 5000, "주류"));
        menu.put("맥주", new MenuItem("맥주", 5000, "주류"));
        menu.put("고량주", new MenuItem("고량주", 35000, "주류"));
    }

    public void printMenu() {
        System.out.println("--- 메뉴판 ---");
        System.out.println("음식: 밥(8000원), 면(9000원), 요리(25000원)");
        System.out.println("음료: 콜라(2000원), 사이다(2000원)");
        System.out.println("주류: 소주(5000원), 맥주(5000원), 고량주(35000원)");
        System.out.println("----------------");
    }

    public MenuItem getMenuItem(String name) {
        return menu.get(name);
    }

    public void addTable(int tableNumber) {
        tables.put(tableNumber, new Table(tableNumber));
    }

    public Table getTable(int tableNumber) {
        return tables.get(tableNumber);
    }

    public void deposit(int amount, String item) {
        this.totalAsset += amount;
        transactionLog.add(new Transaction("입금", amount, item));
        System.out.printf("입금 완료: %d원, 현재 총 자산: %d원\n", amount, this.totalAsset);
    }

    public void withdraw(int amount, String item) {
        if (this.totalAsset >= amount) {
            this.totalAsset -= amount;
            transactionLog.add(new Transaction("출금", amount, item));
            System.out.printf("출금 완료: %d원, 현재 총 자산: %d원\n", amount, this.totalAsset);
        } else {
            System.out.println("잔액이 부족하여 출금할 수 없습니다.");
        }
    }

    public int getTotalAsset() {
        return totalAsset;
    }

    public void endOfDaySummary() {
        int totalSales = 0;
        int totalRefunds = 0;

        for (Transaction trans : transactionLog) {
            if ("입금".equals(trans.getType())) {
                totalSales += trans.getAmount();
            } else if ("출금".equals(trans.getType())) {
                totalRefunds += trans.getAmount();
            }
        }
        System.out.printf("총 판매액: %d원\n", totalSales);
        System.out.printf("총 환불액: %d원\n", totalRefunds);
        System.out.printf("순이익: %d원\n", totalSales - totalRefunds);
        System.out.println("----------------------");
    }
}