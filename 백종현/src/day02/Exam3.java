package day02;

public class Exam3 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("잘못된 입력");
            return;
        }

        int year = Integer.parseInt(args[0]);
        String result = "";
        if (year % 400 == 0) {
            result = "윤년";
        } else if (year % 100 == 0) {
            result = "윤년 아님";
        } else {
            result = (year % 4 == 0) ? "윤년" : "윤년 아님";
        }
        System.out.println(result);
    }
}