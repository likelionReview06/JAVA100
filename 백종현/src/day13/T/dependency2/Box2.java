package day13.T.dependency2;
//의존성
interface IPutAble {
    void put();
}


class Toy implements IPutAble {
    @Override
    public void put() {
        System.out.println("Toy put");
    }
}

class Food implements IPutAble {
    @Override
    public void put() {
        System.out.println("Food put");
    }
}

public class Box2 {
    IPutAble putAble;

    Box2(IPutAble putAble) {
        this.putAble = putAble;
    }

    void put() {
        putAble.put();
    }

    public static void main(String[] args) {
        Box2 toyBox = new Box2(new Toy());
        toyBox.put();

        Box2 foodBox = new Box2(new Food());
        foodBox.put();
    }
}
