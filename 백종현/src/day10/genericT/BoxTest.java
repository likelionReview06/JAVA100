package day10.genericT;

public class BoxTest {
    public static void main(String[] args) {
        GenericBox<Pen> penBox = new GenericBox<>(new Pen("blue", "ballpoint"));
        GenericBox<Food> foodBox = new GenericBox<>(new Food("apple", 1000, 150));
        FoodBox<Apple> appleBox = new FoodBox<>(new Apple(1000, 150));
        FoodBox<Steak> steakBox = new FoodBox<>(new Steak(1000, 150, "medium"));

        penBox.printObject();

        System.out.println("----------------");

        foodBox.printObject();

        System.out.println("----------------");

        appleBox.printObject();

        System.out.println("----------------");

        steakBox.printObject();
    }
}
