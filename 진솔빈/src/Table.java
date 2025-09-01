import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Table {
    private int tableNumber;
    private int totalAmount;
    private List<String> orderLog;
    private List<MenuItem> orderedItems;

    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
        this.totalAmount = 0;
        this.orderLog = new ArrayList<>();
        this.orderedItems = new ArrayList<>();
    }

    public void addOrder(MenuItem item) {
        orderedItems.add(item);
        totalAmount += item.getPrice();
        String logEntry = String.format("[%s] 주문: %s (%d원)", LocalDateTime.now(), item.getName(), item.getPrice());
        orderLog.add(logEntry);
        System.out.println(logEntry);
    }

    public void removeOrder(MenuItem item) {
        if (orderedItems.remove(item)) {
            totalAmount -= item.getPrice();
            String logEntry = String.format("[%s] 취소: %s (%d원)", LocalDateTime.now(), item.getName(), item.getPrice());
            orderLog.add(logEntry);
            System.out.println(logEntry);
        }
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void printOrderSummary() {
        System.out.printf("--- 테이블 %d 주문 현황 ---\n", tableNumber);
        for (String log : orderLog) {
            System.out.println(log);
        }
        System.out.printf("총 금액: %d원\n", totalAmount);
        System.out.println("--------------------------");
    }
}