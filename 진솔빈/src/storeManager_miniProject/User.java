import java.time.LocalDate;

public class User {
    private String username;
    private String password;
    private LocalDate startDate;
    private StoreManager storeManager;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.startDate = LocalDate.now();
        this.storeManager = new StoreManager();
    }

    public String getUsername() {
        return username;
    }

    public StoreManager getStoreManager() {
        return storeManager;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
}