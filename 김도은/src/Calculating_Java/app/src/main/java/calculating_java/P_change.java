package calculating_java;

//후위 표기식 만들 때 사용할 것임
import java.util.Stack;
//StringBuilder도 append를 통해서 값을 넣어서 동적으로 문자열을 추가하고 결과가 문자열로 나와서 사용함

//*중위표기식 문자열을 후위표기식 문자열로 return해주는 class*//

public class P_change {
    // 연산자가 우선순위가 있어서.. 써야하는 메서드합니다..이런
    private int prec(char op) {
        switch (op) {
            case '*': case '/': return 2;
            case '+': case '-': return 1;
            default:            return 0;
        }
    }

    public String postfix_change(String before) {
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new  StringBuilder();

    for(int i = 0; i < before.length(); i++) {
        char ch = before.charAt(i);
        //나중에 끝날 때 공백을 인식해야해서 이 부분 추가함
        if (Character.isWhitespace(ch) )continue;
        //ch가 문자랑 숫자 맞는지 판별해주는 부분
        if (Character.isLetterOrDigit(ch)){
            stringBuilder.append(ch);
        }else if(ch=='('){
            stack.push(ch);
        }else if(ch==')'){
            // 닫는 괄호: '(' 나올 때까지 팝하여 출력 괄호 닫아야해서..ㅇ쩔수
            while (!stack.isEmpty() && stack.peek() != '(') {
                stringBuilder.append(stack.pop());
            }
            if (stack.isEmpty()) {
                throw new IllegalArgumentException("괄호 오타난 듯??");
            }
            //'(' 제거
            stack.pop();
        } else if(ch == '*' || ch == '/' || ch == '+' || ch == '-') {
            //연산자 우선순위 위에 정의했습니다요
            while(!stack.isEmpty() && stack.peek()!='('
                    &&prec(stack.peek()) >= prec(ch)){
                stringBuilder.append(stack.pop());
            }
            stack.push(ch);
        }
        else {
        }
    }
        // 남은 연산자 모두 출력_>후위표기식의 구조
        while (!stack.isEmpty()) {
            char op = stack.pop();
            if (op == '(') {
                throw new IllegalArgumentException("괄호 오타난 듯??");
            }
            stringBuilder.append(op);
        }

        return stringBuilder.toString();
    }
}
