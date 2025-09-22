package day10.collectionsT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person10SortTest {
    public static void main(String[] args) {

        List<Person10> list = new ArrayList<>();

        list.add(new Person10("james", 20, 2000));
        list.add(new Person10("robert", 30, 1000));
        list.add(new Person10("peter", 15, 2000));
        list.add(new Person10("michael", 47, 10000));
        list.add(new Person10("david", 11, 5000));
        list.add(new Person10("charles", 22, 1000));
        list.add(new Person10("james", 22, 1000));
        list.add(new Person10("rora", 11, 4000));
        list.add(new Person10("cristiano", 11, 2000));
        list.add(new Person10("james", 20, 100000));


        System.out.println("===============정렬================");
        Collections.sort(list);
        list.forEach(p -> System.out.println(p + "\n"));

        System.out.println("===============역순 정렬================");
        Collections.sort(list, Collections.reverseOrder());
        list.forEach(p -> System.out.println(p + "\n"));

        System.out.println("===============계좌 잔액 정렬================");
        Collections.sort(list, new Comparator<Person10>() {
            @Override
            public int compare(Person10 o1, Person10 o2) {
                return o2.getAccount() - o1.getAccount();
            }
        });
        list.forEach(p -> System.out.println(p + "\n"));

        System.out.println("===============나이 정렬================");
        Comparator<Person10> ageComparator = new Comparator<Person10>() {
            @Override
            public int compare(Person10 o1, Person10 o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        Collections.sort(list, ageComparator);
        list.forEach(p -> System.out.println(p + "\n"));

        System.out.println("===============이름 정렬================");
        Collections.sort(list, new PersonComparator());
        list.forEach(p -> System.out.println(p + "\n"));

    }
}
