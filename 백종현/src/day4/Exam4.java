package day4;

public class Exam4 {
    public static void main(String[] args) {
        int[][] gugudan = new int[8][9];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                gugudan[i][j] = (i + 2) * (j + 1);
            }
        }

        for (int i = 0; i < 8; i++) {

            System.out.println((i + 2) + "단");

            for (int j = 0; j < 9; j++) {
                System.out.printf("%d * %d = %2d\t", (i + 2), (j + 1), gugudan[i][j]);

                if (j != 0 && (j + 1) % 3 == 0) {
                    System.out.println();
                }
            }
            System.out.println();
        }

    }
}
