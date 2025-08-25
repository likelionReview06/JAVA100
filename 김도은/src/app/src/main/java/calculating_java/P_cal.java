package calculating_java;

import java.util.Stack;

public class P_cal {
    public String postfix_calculation(String before) {
        Stack stack = new Stack();
        char c = ' ';
        double op1 = 0;
        double op2 = 0;

        for (int i = 0; i < before.length(); i++) {
            c = before.charAt(i);

            if (Character.isWhitespace(c)) continue;

            if (Character.isDigit(c)) {
                stack.push(c);
            } else {
                //연산할 숫자 꺼내오는것
                op2 = Double.valueOf(stack.pop().toString());
                op1 = Double.valueOf(stack.pop().toString());

                switch (c) {
                    // op2에 먼저 pop한 이유는 후위 표기법으로 변환할 때 순서가 바뀌기 때문
                    // ex) 3+2 => 스택에 저장 시 3, 2 순으로 저장되는데 스택은 마지막에 push하는겨
                    case '+': stack.push(op1 + op2); break;
                    case '-': stack.push(op1 - op2); break;
                    case '*': stack.push(op1 * op2); break;
                    case '/': stack.push(op1 / op2); break;
                }
            }
        }
        return stack.pop().toString();    }
}
