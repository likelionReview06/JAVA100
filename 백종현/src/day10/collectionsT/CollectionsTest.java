package day10.collectionsT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0){
                list.add("a" + i);
            }else{
                list.add("b" + i);
            }
        }
        System.out.println("초기 리스트");
        System.out.println(list);
        System.out.println();

        Collections.sort(list);
        System.out.println("오름 차순");
        System.out.println(list);
        System.out.println();

        Collections.sort(list,Comparator.reverseOrder());
        System.out.println("내림 차순");
        System.out.println(list);
        System.out.println();

        System.out.println("커스텀 정렬");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char[] c1 = o1.toCharArray();
                char[] c2 = o2.toCharArray();

                int o1Count = 0;
                int o2Count = 0;

                for (char c : c1) {
                    o1Count += (int)c;
                }
                for (char c : c2) {
                    o2Count += (int)c;
                }
                return o2Count - o1Count;
            }
        });
        System.out.println(list);
        System.out.println();

        System.out.println("셔플");
        Collections.shuffle(list);
        System.out.println(list);
        System.out.println();

        System.out.println("최대값");
        System.out.println(Collections.max(list));
        System.out.println();

        System.out.println("최소값");
        System.out.println(Collections.min(list));
        System.out.println();
    }
}
