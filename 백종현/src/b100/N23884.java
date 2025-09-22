package b100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class N23884 {
    static int N, K;
    static int[] arr;
    static TreeMap<Integer, Integer> tm = new TreeMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            tm.put(arr[i], i);
        }

        for (int i = N -1 ; i > 0; i--) {
            int maxV =  tm.lastKey();
            int maxI = tm.get(maxV);

            if (maxI == i) {
                tm.remove(maxV);
                continue;
            }

            int temp = arr[i];
            arr[i] = arr[maxI];
            arr[maxI] = temp;
            tm.remove(maxV);
            tm.put(temp, maxI);

            if (--K == 0) {
                for (int j = 0; j < N; j++) {
                    if (j != 0){
                        sb.append(" ");
                    }
                    sb.append(arr[j]);
                }
                System.out.println(sb.toString());
                return;
            }
        }

        System.out.println("-1");
    }
}
