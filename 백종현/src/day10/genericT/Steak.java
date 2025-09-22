package day10.genericT;

public class Steak extends Food{
    String cook;

    public Steak(int price, int kcal, String cook) {
        super("steak", price, kcal);
        this.cook = cook;
    }

    @Override
    public String toString() {
        return "Steak{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", kcal=" + kcal +
                ", cook=" + cook  +
                '}';
    }
}
