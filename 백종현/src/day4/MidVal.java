package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MidVal {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int t = 0; t < T; t++) {
            int M = Integer.parseInt(br.readLine()); // 수열 길이
            int[] nums = new int[M];
            int idx = 0;

            // 수열 입력 (한 줄에 최대 10개씩 주어짐)
            while (idx < M) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    nums[idx++] = Integer.parseInt(st.nextToken());
                }
            }

            // 중앙값 저장 리스트
            List<Integer> medians = new ArrayList<>();

            // 최대 힙 (작은 값들)
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            // 최소 힙 (큰 값들)
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            for (int i = 0; i < M; i++) {
                int num = nums[i];

                // 삽입 (두 힙 크기 맞춰주기)
                if (maxHeap.size() == minHeap.size()) {
                    maxHeap.offer(num);
                } else {
                    minHeap.offer(num);
                }

                // 두 힙의 순서가 잘못되면 교환
                if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                    int a = maxHeap.poll();
                    int b = minHeap.poll();
                    maxHeap.offer(b);
                    minHeap.offer(a);
                }

                // 홀수번째 입력 → 중앙값 추가
                if (i % 2 == 0) {
                    medians.add(maxHeap.peek());
                }
            }

            // 출력
            sb.append(medians.size()).append("\n");
            for (int i = 0; i < medians.size(); i++) {
                sb.append(medians.get(i)).append(" ");
                if ((i + 1) % 10 == 0) sb.append("\n"); // 10개마다 줄바꿈
            }
            if (medians.size() % 10 != 0) sb.append("\n");
        }

        System.out.print(sb);
    }
}
