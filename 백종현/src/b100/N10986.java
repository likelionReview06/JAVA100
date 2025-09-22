package b100;

import java.io.*;
import java.util.*;

public class N10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] count = new long[M]; // 나머지 개수 저장
        long[] prefix = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            prefix[i] = (prefix[i - 1] + num) % M;
            count[(int) prefix[i]]++;
        }

        long answer = count[0]; // 나머지가 0인 경우

        for (int i = 0; i < M; i++) {
            if (count[i] > 1){
                answer += count[i] * (count[i] - 1) / 2;// nC2
            }
        }
        System.out.println(answer);
    }
}
