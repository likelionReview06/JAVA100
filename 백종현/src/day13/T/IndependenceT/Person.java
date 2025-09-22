package day13.T.IndependenceT;
//독립성
public class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class Dog {
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void bark() {
        System.out.println("멍멍");
    }

    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class TestMain {
    public static void main(String[] args) {
        Person person = new Person(20, "홍길동");
        System.out.println(person);
        Dog dog = new Dog("멍멍이", 5);
        System.out.println(dog);
        dog.bark();
    }
}
