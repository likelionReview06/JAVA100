package day9;

import java.util.*;

public class PersonMap2 {
    public static void main(String[] args) {
        Map<String, List<Person>> map = new HashMap<>();

        List<Person> class1 = new ArrayList<>();
        List<Person> class2 = new ArrayList<>();
        List<Person> class3 = new ArrayList<>();

        map.put("1학년", class1);
        map.put("2학년", class2);
        map.put("3학년", class3);



        for (int i = 1; i <= 10; i++) {
            Person person1 = factory(1, i);
            Person person2 = factory(2, i);
            Person person3 = factory(3, i);

            class1.add(person1);
            class2.add(person2);
            class3.add(person3);
        }

        Iterator<Map.Entry<String, List<Person>>> it = map.entrySet().iterator();


        while (it.hasNext()){
            var entry = it.next();
            System.out.println(entry.getKey());
            Iterator<Person> it2 = entry.getValue().iterator();
            for (Person person : entry.getValue()) {
                System.out.println(person);
            }

            Collections.sort(entry.getValue(), new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    return o1.getCode() - o2.getCode();
                }
            });

            System.out.println();
        }

        System.out.println("\n-------------------------------\n");

        for (Map.Entry<String, List<Person>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            for (Person person : entry.getValue()) {
                System.out.println(person);
            }
            System.out.println();
        }



    }

    static Person factory(int classNum, int i) {
        String name;
        int age;
        int num;

        switch (classNum){
            case 1 -> {
                name = i%3 == 0 ? "name" + i : "name";
                age = i%2 == 0 ? 8 : 9;
                num = i;
            }
            case 2 -> {
                name = "name";
                age = 9;
                num = 11 - i;
            }
            case 3 -> {
                name = "name" + i;
                age = 10;
                num = i % 2 == 0 ? 1 : i;
            }
            default -> throw new IllegalArgumentException("Invalid class number");
        }

        return new Person(name, age, num);
    }
}
