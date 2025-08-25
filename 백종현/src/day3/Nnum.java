package day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Nnum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());


        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(N * N, (a, b) -> b - a);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maxHeap.offer(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < N; i++) {
            int max = maxHeap.poll();
            if (i == N - 1) {
                System.out.print(max);
            }
        }
    }
}
