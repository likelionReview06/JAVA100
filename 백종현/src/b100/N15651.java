package b100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N과M3
public class N15651 {
    static int[] path;
    static StringBuilder sb = new StringBuilder();
    static int N, M;


    static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                if (i > 0) sb.append(' ');
                sb.append(path[i]);
            }
            sb.append('\n');
            return;
        }
        for (int i = 1; i <= N; i++) {
            path[depth] = i;
            dfs(depth + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄 입력
        N = Integer.parseInt(st.nextToken()); //토큰단위로 나누고
        M = Integer.parseInt(st.nextToken());

        path = new int[M];

        dfs(0);
        System.out.print(sb.toString());
    }
}

