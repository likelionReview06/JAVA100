package day6;

import java.util.Stack;

public class CalculatorAction { // 계산 수행 하는 클래스
    public String toPostfix(String infix) {
        String[] stringArray = infix.split(" "); // 문자열 띄워쓱기 단위로 나눔
        Stack<String> stack = new Stack<>(); // 후위식 변환을 위한 스텍 
        StringBuilder postfixExpression = new StringBuilder(); // 가변적인 문자열을 만들기 우ㅣ해 사용

        for (String element : stringArray) { // 배열 안덱스를 따라 for문 돔
            switch (element) {
                case "+":
                case "-":
                    // 스택의 맨 위에 있는 연산자가 우선순위가 높다면 pop 후 결과에 추가
                    while (!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                        postfixExpression.append(stack.pop()).append(" ");
                    }
                    stack.push(element); // 현재 연산자 push
                    break;
                case "*":
                case "/":
                    stack.push(element); // 현재 연산자 push
                    break;
                case "(":
                    stack.push(element);
                    break;
                case ")":
                    // 왼쪽 괄호가 나올 때까지 스택의 연산자를 pop 후 결과에 추가
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        postfixExpression.append(stack.pop()).append(" ");
                    }
                    stack.pop(); // 왼쪽 괄호 제거
                    break;
                default:// 숫자인 경우 결과에 추가
                    postfixExpression.append(element).append(" ");
                    break;
            }
        }

        // 스택에 빌때까지 남아 있는 연산자를 모두 결과에 추가
        while (!stack.isEmpty()) {
            postfixExpression.append(stack.pop()).append(" ");
        }
        return postfixExpression.toString().trim(); // 결과의 마지막 공백 제거
    }
    
    private boolean isNumeric(String str) {
        // 문자열이 숫자인지 확인하는 함수
        try {
            Double.parseDouble(str);
            return true; //변환 가능시 참 반환
        } catch (NumberFormatException e) {
            return false; // 불가능시 거짓 반환
        }
    }
    
    private boolean isOperator(String str) {
        // 문자열이 연산자인지 확인하는 함수
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
    
    private double performOperation(double operand1, double operand2, String operator) {
        // 연산을 수행하는 함수 (피연산자1 , 피연산자2, 연산자)
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else { //나눗셈 예외처리
                    throw new ArithmeticException("0은 못나눔");
                }
            default:
                throw new IllegalArgumentException("이상한 문자 포함" + operator);
        }
    }
    
    public String result(String numStr) { // 후위식 계산
        String[] stringArray = numStr.split(" "); // 문자열 " " 단위로 나눔 
        Stack<String> stack = new Stack<>(); //연산 수행을 위한 스텍 

        for (String element : stringArray) {
            if (isNumeric(element)) {// 피연산자일 경우 스택에 삽입
                stack.push(element);
            } else if (isOperator(element)) {
                // 연산자일 경우 필요한 피연산자를 스택에서 pop하여 연산하고 결과를 다시 스택에 삽입
                double operand2 = Double.parseDouble(stack.pop());
                double operand1 = Double.parseDouble(stack.pop());
                double result = performOperation(operand1, operand2, element);
                stack.push(String.valueOf(result));
            }
        }

        // 수식이 끝나면 스택을 pop하여 최종 결과를 반환
        return stack.isEmpty() ? "계산 실패" : stack.pop();
    }

    public static void main(String[] args) {
    	CalculatorAction calculatorAction = new CalculatorAction();
    	 // 테스트 1: 후위 표기식 변환
        String infixExpression = "3 + 5 * ( 2 - 8 )"; //중위 표기법
        String postfixExpression = calculatorAction.toPostfix(infixExpression);
        System.out.println("중위식: " + infixExpression); // 원래 중위식 
        System.out.println("후위식: " + postfixExpression); // 후위식으로 변환

        // 테스트 2: 후위 표기식 계산
        String result = calculatorAction.result(postfixExpression);
        System.out.println("후위식: " + postfixExpression);
        System.out.println("결과: " + result);
    }
}
