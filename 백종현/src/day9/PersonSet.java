package day9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PersonSet {
    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        set.add(new Person("John", 30, 1111));
        set.add(new Person("John", 30, 2211));
        set.add(new Person("John", 30, 2211));
        set.add(new Person("John", 30, 2212));
        set.add(new Person("John", 30, 2215));
        set.add(new Person("John", 30, 1));
        set.add(new Person("John", 30, 2));
        set.add(new Person("John", 30, 3));

        Iterator<Person> it = set.iterator();

        while (it.hasNext()){
            Person p = it.next();
            System.out.println(p);
            if (p.getCode() > 3)
                it.remove();
        }
        System.out.println("-------------------");

        System.out.println(set.size());

        for (Person p : set) {
            System.out.println(p);
        }
    }
}
