package day4;

public class Eraser {
    private double length;
    private String maker;

    public Eraser(double length, String maker) {
        this.length = length;
        this.maker = maker;
    }

    public void removeWord(String ... words) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (length < 0.25) {
                    System.out.println("지우개 다 써버렸다...");
                    return;
                }
                length -= 0.25;
            }
        }
        System.out.println("지우개 사용 완료");
        System.out.println("지우개 " + length + "cm 남았다...");
    }

    public static void main(String[] args) {

        Eraser eraser = new Eraser(10.0, "Eraser");

        eraser.removeWord("Hello");

        eraser.removeWord("Hello", "World");

        eraser.removeWord("Hello", "World", "Java", "Spring", "Boot", "React");
    }
}
