package day11;

import java.io.*;

public class IOT {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("src/day11/test.txt", true);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOut));
        bw.newLine();
        bw.write("hello");
        bw.flush();
        bw.close();

        FileInputStream file = new FileInputStream("src/day11/test.txt");

        BufferedReader br = new BufferedReader(new InputStreamReader(file));

        String s = br.readLine();
        while (s != null) {
            System.out.println(s);
            s = br.readLine();
        }
        br.close();

    }
}
