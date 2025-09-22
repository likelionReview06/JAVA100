package b100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//NM4
public class N15652 {
    static int[] path;
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                if (i > 0) sb.append(' ');
                sb.append(path[i]);
            }
            sb.append('\n');
            return;
        }
        for (int i = start; i <= N; i++) {
            path[depth] = i;
            dfs(depth + 1, i);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄 입력
        N = Integer.parseInt(st.nextToken()); //토큰단위로 나누고
        M = Integer.parseInt(st.nextToken());

        path = new int[M];

        dfs(0, 1);
        System.out.print(sb.toString());
    }
}
