package b100;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//N과M1
public class N15649  {
    static boolean[] visited;
    static int[] path;
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    static void dfs(int depth) {
        if (depth == M) { // 마지막 번째면
            for (int i = 0; i < M; i++) {
                if (i > 0) sb.append(' ');
                sb.append(path[i]);
            }
            sb.append('\n');
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {// 방문 안하묜
                visited[i] = true; //방문하고
                path[depth] = i; //글자적고
                dfs(depth + 1); //다음거뽑으로 가고
                visited[i] = false; //복구
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄 입력
        N = Integer.parseInt(st.nextToken()); //토큰단위로 나누고
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        path = new int[M];

        dfs(0);
        System.out.print(sb.toString());
    }
}
