package day9;


import java.util.*;

public class PersonMap {
    public static void main(String[] args) {
        Map<String, Set<Person>> map = new HashMap<>();

        Set<Person> class1 = new HashSet<>();
        Set<Person> class2 = new HashSet<>();
        Set<Person> class3 = new HashSet<>();

        map.put("1학년", class1);
        map.put("2학년", class2);
        map.put("3학년", class3);


        for (int i = 1; i <= 10; i++) {
            class1.add(new Person("name" + i, 8, i));
        }

        for (int i = 1; i <= 10; i++) {
            class2.add(new Person("name" + 1, 9, 1));
        }

        for (int i = 1; i <= 10; i++) {
            class3.add(new Person("name" + 1, 10, i/2));
        }

        Iterator<Map.Entry<String, Set<Person>>> it = map.entrySet().iterator();

        while (it.hasNext()){
            var entry = it.next();
            System.out.println(entry.getKey());
            Iterator<Person> it2 = entry.getValue().iterator();
            while (it2.hasNext()){
                var person = it2.next();
                System.out.println(person);
                if (person.getCode() % 2 == 0)
                    it2.remove();
            }
            System.out.println();
        }

        System.out.println("\n-------------------\n");


        for (Map.Entry<String, Set<Person>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            for (Person person : entry.getValue()) {
                System.out.println(person);
            }
            System.out.println();
        }

    }
}
