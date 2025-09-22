package b100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N11725 {
    static int N;                          // 노드 개수
    static ArrayList<Integer>[] graph;     // 그래프 (인접 리스트)
    static int[] parent;                   // 부모를 저장할 배열
    static boolean[] visited;              // 방문 체크 배열


    // BFS 탐색
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            // 현재 노드와 연결된 노드들 확인
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = cur;  // 부모 기록
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력 (트리는 무방향 그래프이므로 양쪽에 추가)
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }


        // 부모, 방문 배열 초기화
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        // BFS 실행 (루트 = 1)
        bfs(1);

        // 결과 출력 (2번 노드부터 N번까지 부모 출력)
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }
}
