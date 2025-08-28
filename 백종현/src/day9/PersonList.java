package day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonList {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();

        list.add(new Person("a", 10, 1));
        list.add(new Person("b", 7, 4));
        list.add(new Person("b", 7, 2));
        list.add(new Person("b", 7, 5));
        list.add(new Person("b", 7, 3));
        list.add(new Person("b", 7, 4));
        list.add(new Person("a", 7, 4));

        Collections.sort(list);

        for (Person p : list) {
            System.out.println(p);
        }

    }
}
