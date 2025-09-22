package b100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class N1260 {

    // 그래프: 1번부터 N번까지 사용하므로 N+1 크기로 만든다.
    static ArrayList<Integer>[] graph;

    // 방문 여부 체크 배열(DFS, BFS 각각 새로 사용)
    static boolean[] visited;

    // 출력 성능을 위해 StringBuilder 사용 (println 반복보다 빠름)
    static StringBuilder sb = new StringBuilder();

    // 정점 수 N, 간선 수 M, 시작 정점 V
    static int N, M, V;

    public static void main(String[] args) throws Exception {
        // ---- 입력 처리: BufferedReader + StringTokenizer ----
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: N(정점 수) M(간선 수) V(시작 정점)
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // ---- 그래프 초기화 ----
        graph = new ArrayList[N + 1];  // 1-indexed 사용
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 다음 M줄: 간선 정보 (무방향 그래프)
        // 예) "a b"가 주어지면 a-b, b-a 모두 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        // ---- 방문 순서 규칙을 맞추기 위해 인접 리스트 정렬 ----
        // 작은 정점 번호부터 방문해야 하므로 오름차순 정렬 필수
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // ---- DFS 실행 ----
        visited = new boolean[N + 1];  // DFS용 방문 배열
        dfs(V);                        // 시작 정점 V에서 시작
        sb.append('\n');               // DFS 출력 후 줄바꿈

        // ---- BFS 실행 ----
        visited = new boolean[N + 1];  // BFS용 방문 배열(초기화 필수)
        bfs(V);                        // 시작 정점 V에서 시작
        sb.append('\n');               // BFS 출력 후 줄바꿈

        // ---- 결과 출력 ----
        System.out.print(sb.toString());
    }

    /**
     * 깊이 우선 탐색(DFS)
     * - 현재 정점을 방문 처리하고 출력한 뒤,
     *   인접한 정점들을 "작은 번호부터" 재귀적으로 방문한다.
     * - 재귀 깊이는 최악(N=1000)일 때도 Java 기본 스택 한도에서 안전한 편.
     *   (만약 더 큰 입력이라면 스택 오버플로우 방지를 위해 반복(스택) 방식 고려)
     */
    static void dfs(int node) {
        visited[node] = true;          // 현재 정점 방문 표시
        sb.append(node).append(' ');   // 방문 순서에 현재 정점 기록

        // 인접 정점들을 작은 번호부터 순서대로 방문
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);             // 아직 방문 안 했으면 재귀 호출
            }
        }
    }

    /**
     * 너비 우선 탐색(BFS)
     * - 큐(Queue)를 사용하여 시작 정점에서 가까운 정점부터 차례로 방문.
     * - 방문 직후 바로 큐에 넣고 방문 표시해야 중복 삽입을 방지 가능.
     */
    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();  // LinkedList보다 가벼운 ArrayDeque 권장
        visited[start] = true;                  // 시작 정점 방문 표시
        q.add(start);                           // 큐에 시작 정점 삽입

        while (!q.isEmpty()) {
            int cur = q.poll();                 // 현재 정점 꺼내기
            sb.append(cur).append(' ');         // 방문 순서 기록

            // 인접 정점들을 작은 번호부터 확인
            for (int next : graph[cur]) {
                // 아직 방문하지 않았다면 방문 처리 후 큐에 삽입
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
