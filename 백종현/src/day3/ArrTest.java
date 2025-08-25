package day3;



public class ArrTest {
    public static void main(String[] args) {

        int [] sores = {95, 87, 66 ,73, 82};

        int total = 0;
        int avg = 0;
        int max = 0;

        // 순회
        for (int score : sores) {
            System.out.println(score);
            total += score;
            if (score > max) {
                max = score;
            }
        }
        avg = total / sores.length;

        System.out.println("\n---------------------\n");

        System.out.println("total : " + total);
        System.out.println("avg : " + avg);
        System.out.println("max : " + max);

    }
}
