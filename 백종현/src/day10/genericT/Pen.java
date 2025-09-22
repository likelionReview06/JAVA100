package day10.genericT;

public class Pen {
    String color;
    String type;

    public Pen(String color, String type) {
        this.color = color;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
