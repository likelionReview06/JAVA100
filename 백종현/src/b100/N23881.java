package b100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N23881 {
    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int i = N - 1; i > 0; i--) {
            int maxIdx = i;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[maxIdx]) maxIdx = j;
            }
            if (maxIdx != i) {
                int num1 = arr[i];
                int num2 = arr[maxIdx];
                int tmp = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = tmp;
                if (--K == 0) {
                    System.out.println(num1 + " " + num2);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}