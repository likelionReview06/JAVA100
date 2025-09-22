package day13;

public class TVFactory {
    public static TV makeTV(String type) {
        return switch (type) {
            case "LTV" -> new LTV();
            case "STV" -> new STV();
            default -> null;
        };
    }
}
