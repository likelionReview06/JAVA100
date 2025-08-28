package day9;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private final int code;

    public Person(String name, int age, int code) {
        this.name = name;
        this.age = age;
        this.code = code;
    }

    @Override
    public int compareTo(Person p) {
        int result = this.name.compareTo(p.name);
        if (result != 0) return result;

        result = Integer.compare(this.age, p.age);
        if (result != 0) return result;

        return Integer.compare(this.code, p.code);
    }

    public static int compareTo(Person p1, Person p2) {
        int result = p1.name.compareTo(p2.name);
        if (result != 0) return result;

        result = Integer.compare(p1.age, p2.age);
        if (result != 0) return result;

        return Integer.compare(p1.code, p2.code);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return code == person.code;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", code=" + code +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCode() {
        return code;
    }
}
