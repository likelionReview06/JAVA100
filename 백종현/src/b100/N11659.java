package b100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); //수의 개수 N
        int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수 M

        //둘째 줄에는 N개의 수가 주어진다

        int[] nums = new int[N +1];

        // 누적합 배열
        int[] prefix = new int[N + 1];


        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N ; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i-1] + nums[i];
        }

        //셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(prefix[end] - prefix[start - 1]).append("\n");
        }
        System.out.println(sb);

    }
}
