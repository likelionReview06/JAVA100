package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StringBom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String bom = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if(stack.size() >= bom.length()) {
                boolean flag = true;
                for(int j = 0; j < bom.length(); j++) {
                    if(bom.charAt(j) != stack.get(stack.size() - bom.length() + j)){
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    for(int k=0; k<bom.length(); k++) {
                        stack.pop();
                    }
                }
            }
        }

        if(stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            for(Character c : stack) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
