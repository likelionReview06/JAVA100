package day02;

public class Exam2 {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("잘못된 입력");
            return;
        }

        int dayNum = Integer.parseInt(args[0]);
        String day = "";

        switch (dayNum) {
            case 1:
                day = "월요일";
                break;
            case 2:
                day = "화요일";
                break;
            case 3:
                day = "수요일";
                break;
            case 4:
                day = "목요일";
                break;
            case 5:
                day = "금요일";
                break;
            case 6:
                day = "토요일";
                break;
            case 7:
                day = "일요일";
                break;
            default:
                day = "잘못된 입력";
        }
        System.out.println(day);
    }
}
