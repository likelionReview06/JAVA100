package day5.exam.e3;

public class Shape {
    public double width, height;
    public String name;

    Shape(String name, double width, double height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle(10, 20);
        Circle circle = new Circle(10);
        Square square = new Square(10, 10);

        System.out.println(triangle.getName() + ": " + triangle.getArea());
        System.out.println(circle.getName() + ": " + circle.getArea());
        System.out.println(square.getName() + ": " + square.getArea());
    }
}

class Triangle extends Shape {
    public Triangle(double width, double height) {
        super("삼각형", width, height);
    }

    @Override
    public double getArea() {
        return super.getArea() / 2;
    }
}

class Circle extends Shape {

    /**
     * 원 생성자
     * @param radius 반지름
     */
    public Circle(double radius) {
        super("원", radius, radius);
    }

    @Override
    public double getArea() {
        return super.getArea() * 3.14;
    }
}

class Square extends Shape {
    Square(double width, double height) {
        super("사각형", width, height);
    }
}
