package calculating_java;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String infix = scanner.nextLine();

        P_change converter = new P_change();
        P_cal calc = new P_cal();
        // 중위(일반적인 수식을 말하는것!) -> 후위(컴퓨터가 이해할 수 있는 수식!!)
        String postfix = converter.postfix_change(infix);
        System.out.println(postfix);
        // 후위를 마지막으로 계산함!!
        String result = calc.postfix_calculation(postfix);
        System.out.println(result);

        scanner.close();
    }
}