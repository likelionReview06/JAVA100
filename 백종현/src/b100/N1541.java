package b100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] strs = br.readLine().split("-");

        int result = sum(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            result -= sum(strs[i]);
        }

        System.out.println(result);
    }

    private static int sum(String str){
        String [] strs = str.split("\\+");
        int sum = 0;
        for (String s : strs) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

}
