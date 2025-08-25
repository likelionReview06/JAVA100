package day02;

public class Exam {
    public static void main(String[] args) {

        if (args.length == 3) {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            String op = args[2];

            switch (op) {
                case "+":
                    System.out.println(num1 + num2);
                    break;
                case "-":
                    System.out.println(num1 - num2);
                    break;
                case "*":
                    System.out.println(num1 * num2);
                    break;
                case "/":
                    System.out.println(num1 / num2);
                    break;
                default:
                    System.out.println("잘못된 입력");
            }
        }else {
            System.out.println("잘못된 입력");
        }
    }
}
