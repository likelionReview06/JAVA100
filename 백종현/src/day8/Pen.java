package day8;

import java.util.Objects;

public class Pen {
    String color;
    int inkCapacity;
    int price;

    public Pen(String color, int inkCapacity, int price) {
        this.color = color;
        this.inkCapacity = inkCapacity;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return Objects.equals(color, pen.color);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(color);
    }

    public static void main(String[] args) {
        Pen pen = new Pen("red", 10, 1000);
        Pen pen2 = new Pen("red", 10, 1000);
        Pen pen3 = new Pen("blue", 20, 2000);
        System.out.println(pen.equals(pen2));
        System.out.println(pen.equals(pen3));
    }
}
