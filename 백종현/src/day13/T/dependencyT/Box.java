package day13.T.dependencyT;
//종속성
//강한 결합
public class Box {
    Item item = new Item();

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public static void main(String[] args) {
        Box box = new Box();
        box.setItem(new Item());

        Item item = box.getItem();
        System.out.println(item);
    }
}
class Item{
    String name;
}
