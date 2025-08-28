package b100;

import java.io.*;
import java.util.*;

public class N7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> que = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char code = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                switch (code){
                    case 'I':
                        que.put(n, que.getOrDefault(n, 0) + 1);
                        break;
                    case 'D':
                        if (que.isEmpty())
                            continue;

                        int num = n == 1 ? que.lastKey() : que.firstKey();
                        if (que.put(num, que.get(num) - 1) == 1)
                            que.remove(num);
                        break;
                }
            }
            String result = que.isEmpty() ? "EMPTY\n" : que.lastKey() + " " + que.firstKey() + "\n";
            sb.append(result);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}