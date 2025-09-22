package day10.collectionsT;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person10> {
    @Override
    public int compare(Person10 o1, Person10 o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
