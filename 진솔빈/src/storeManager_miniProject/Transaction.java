import java.time.LocalDateTime;

public class Transaction {
    private String type;
    private int amount;
    private String item;
    private LocalDateTime timestamp;

    public Transaction(String type, int amount, String item) {
        this.type = type;
        this.amount = amount;
        this.item = item;
        this.timestamp = LocalDateTime.now();
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: %d원 (%s)",
                timestamp.toString(), type, amount, item);
    }
}