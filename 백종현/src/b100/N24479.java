package b100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class N24479 {
    static int N, M, R;
    static int[] visited;
    static TreeSet<Integer>[] edges;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int start){
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        int i = 1;

        while (!stack.isEmpty()){
            int now  = stack.pop();
            if(visited[now] != 0)continue;
            visited[now] = i++;

            Iterator<Integer> it  = edges[now].descendingIterator();
            while(it.hasNext()){
                int next = it.next();
                if(visited[next] == 0) stack.push(next);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        visited = new int[N+1];
        edges = new TreeSet[N+1];

        for (int i = 0; i < N+1; i++) {
            edges[i] = new TreeSet<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            edges[start].add(end);
            edges[end].add(start);
        }

//        System.out.println("--------------------------");
//        Iterator<Integer> it  = edges[1].descendingIterator();
//        while(it.hasNext()){
//            int next = it.next();
//            System.out.println(next);
//        }
//        System.out.println("--------------------------");

        dfs(R);

        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append('\n');
        }
        System.out.print(sb.toString());

    }
}
