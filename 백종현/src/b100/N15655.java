package b100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//NM6
public class N15655 {
    static int N, M;
    static int[] path;
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                if (i > 0) sb.append(' ');
                sb.append(path[i]);
            }
            sb.append('\n');
            return;
        }
        for (int i = start; i < N; i++) {
            path[depth] = list.get(i);
            dfs(depth + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        path = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);
        dfs(0,0);
        System.out.println(sb.toString());
    }
}
