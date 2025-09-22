package day10.collectionsT;

import java.util.Objects;

public class Person10 implements Comparable<Person10>{
    private String name;
    private int age;
    private int account;

    public Person10(String name, int age, int account) {
        this.name = name;
        this.age = age;
        this.account = account;
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

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int deposit(int money) {
        account += money;
        return account;
    }

    public int withdraw(int money) {
        account -= money;
        return account;
    }

    @Override
    public String toString() {
        return "이름: " + name + "\n나이: " + age + "\n계좌: " + account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person10 person10 = (Person10) o;
        return age == person10.age && account == person10.account && Objects.equals(name, person10.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Person10 o) {
        int nameCompare = this.name.compareTo(o.name);
        if (nameCompare != 0) {
            return nameCompare;
        }
        int ageCompare = this.age - o.age;
        if (ageCompare != 0) {
            return ageCompare;
        }
        return this.account - o.account;
    }
}
